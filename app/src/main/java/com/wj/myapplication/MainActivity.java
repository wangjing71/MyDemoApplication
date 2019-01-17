package com.wj.myapplication;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baidu.aip.asrwakeup3.core.mini.AutoCheck;
import com.baidu.aip.asrwakeup3.core.parms.OfflineRecogParams;
import com.baidu.aip.asrwakeup3.core.recog.MyRecognizer;
import com.baidu.aip.asrwakeup3.core.recog.RecogResult;
import com.baidu.aip.asrwakeup3.core.recog.listener.StatusRecogListener;
import com.baidu.speech.asr.SpeechConstant;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.LinkedHashMap;
import java.util.Map;

import io.reactivex.functions.Consumer;


public class MainActivity extends BaseActivity{

    private Button start,stop;
    private TextView tv;
    private MyRecognizer myRecognizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        start = findViewById(R.id.button);
        stop = findViewById(R.id.button2);
        tv = findViewById(R.id.textView);
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.requestEach(Manifest.permission.READ_PHONE_STATE,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE
                ,Manifest.permission.RECORD_AUDIO)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                    }
                });
    }

    @Override
    protected void initData() {
        myRecognizer = new MyRecognizer(this,new StatusRecogListener(){
            @Override
            public void onAsrPartialResult(String[] results, RecogResult recogResult) {
                tv.append(results[0] + "\n");
            }
        });
        if (true) {
            // 基于DEMO集成1.4 加载离线资源步骤(离线时使用)。offlineParams是固定值，复制到您的代码里即可
            Map<String, Object> offlineParams = OfflineRecogParams.fetchOfflineParams();
            myRecognizer.loadOfflineEngine(offlineParams);
        }
    }

    @Override
    protected void setEvent() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });
    }

    protected void start() {
        tv.setText("");
        Map<String, Object> params = new LinkedHashMap<String, Object>();
        if (true) {
            params.put(SpeechConstant.DECODER, 2);
        }
        // 基于SDK集成2.1 设置识别参数
        params.put(SpeechConstant.ACCEPT_AUDIO_VOLUME, false);
        // params.put(SpeechConstant.NLU, "enable");
        // params.put(SpeechConstant.VAD_ENDPOINT_TIMEOUT, 0); // 长语音
        // params.put(SpeechConstant.IN_FILE, "res:///com/baidu/android/voicedemo/16k_test.pcm");
        // params.put(SpeechConstant.VAD, SpeechConstant.VAD_DNN);
        // params.put(SpeechConstant.PID, 1537); // 中文输入法模型，有逗号
        // 请先使用如‘在线识别’界面测试和生成识别参数。 params同ActivityRecog类中myRecognizer.start(params);
        // 复制此段可以自动检测错误
        (new AutoCheck(getApplicationContext(), new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 100) {
                    AutoCheck autoCheck = (AutoCheck) msg.obj;
                    synchronized (autoCheck) {
                        String message = autoCheck.obtainErrorMessage(); // autoCheck.obtainAllMessage();
                        tv.append(message + "\n");
                        // 可以用下面一行替代，在logcat中查看代码
                        // Log.w("AutoCheckMessage", message);
                    }
                }
            }
        },true)).checkAsr(params);
        myRecognizer.start(params);
    }
}
