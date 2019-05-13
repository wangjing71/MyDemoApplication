package com.wj.myapplication;

import android.view.View;
import android.widget.Button;

import com.igexin.sdk.PushManager;


public class MainActivity extends BaseActivity {

    private Button button;

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
}
