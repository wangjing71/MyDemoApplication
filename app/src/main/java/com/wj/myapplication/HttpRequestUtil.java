package com.wj.myapplication;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

/**
 * author wangjing
 * Date 2019/8/28
 * Description
 */
public class HttpRequestUtil {
    public static String HOST = "https://mbusihall.sh.chinamobile.com:2443/cmbh3"; //请求的地址

    public interface StringCallBack {
        void onSuccess(String result);
        void onFail();
    }

    //主要请求逻辑
    public static void request(Context context, String path, String parms, final StringCallBack callback) {
        final Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0) {//成功
                    String result = msg.obj.toString();
                    if (callback != null) {
                        callback.onSuccess(result);
                    }
                } else if (msg.what == 1) {//失败
                    if (callback != null) {
                        callback.onFail();
                    }
                }
            }
        };

        Log.i("====入参",parms);
        OkGo.<String>post(HOST + path)
                .tag(context)
                .headers("User-Agent","Mozilla/5.0 (Linux; U; Android 8.0.0; zh-cn; MI 5 Build/OPR1.170623.032) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30")
                .upJson(parms)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Message message = Message.obtain();
                        message.obj = response.body();
                        message.what = 0;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessage(message);
                    }
                });
    }
}
