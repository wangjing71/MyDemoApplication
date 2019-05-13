package com.wj.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;

import com.igexin.sdk.PushManager;


public class MainActivity extends BaseActivity {

    private Button button;

    private GTuiMessageBroadcastReceiver gTuiMessageBroadcastReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        button = findViewById(R.id.button);
    }

    @Override
    protected void initData() {
        PushManager.getInstance().initialize(getApplicationContext(), DemoPushService .class);
        PushManager.getInstance().registerPushIntentService(getApplicationContext(), DemoIntentService .class);
        //注册广播监听登录状态变化
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("login_state_change");
        gTuiMessageBroadcastReceiver = new GTuiMessageBroadcastReceiver();
        localBroadcastManager.registerReceiver(gTuiMessageBroadcastReceiver, intentFilter);




    }

    @Override
    protected void setEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSomeThing();
            }
        });
    }

    private void doSomeThing() {

    }

    public class GTuiMessageBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {



        }
    }
}
