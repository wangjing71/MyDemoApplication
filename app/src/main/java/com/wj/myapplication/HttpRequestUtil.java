package com.wj.myapplication;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

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

//        String entry = obtinRequestParam(context, parms);
//        Log.i("====入参", entry);
        OkGo.<String>post(HOST + path)
                .tag(context)
                .headers("User-Agent", "Mozilla/5.0 (Linux; U; Android 8.0.0; zh-cn; MI 5 Build/OPR1.170623.032) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30")
                .upJson(Des3.encode(parms))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Message message = Message.obtain();
                        message.obj = Des3.decode(response.body());
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


//    private static String obtinRequestParam(Context context, String params) {
//        JSONObject json = null;
//        try {
//            if (TextUtils.isEmpty(params)) {
//                json = new JSONObject();
//            } else {
//                json = new JSONObject(params);
//            }
//            JSONObject device = new JSONObject()
//                    .put("os", "android")
//                    .put("model", RichenInfoUtil.getModel())
//                    .put("osVersion", RichenInfoUtil.getAndroidSDKVersion())
//                    .put("density", RichenInfoUtil.getDensity(context))
//                    .put("token", getToken())
//                    .put("appVersion", RichenInfoUtil.getVersion(context));
//            DeviceIDUtil deviceIDUtil = new DeviceIDUtil(context);
//            device.put("cid", deviceIDUtil.getID());
//            device.put("c_id", deviceIDUtil.getID());
//            //新APP增加标识符
//            device.put("clientId", "1");
//
//            //增加渠道标识
//            device.put("channelId", context.getString(R.string.channel_id));
//            //增加服务协议号
//            device.put("protocolId", SharedPreferenceUtil.getProtocolId(context));
//            json.put("device", device);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return json.toString();
//    }
}
