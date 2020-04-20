package com.wj.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


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

    }

    @Override
    protected void setEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSomeThing();
            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置背景模糊
                getWindow().setBackgroundDrawableResource(R.color.gray);
            }
        });
    }

    private void doSomeThing() {
        Intent intent = new Intent();
        intent.putExtra("account", "13681768891"); //主账号
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClassName("com.richeninfo.pboss", "com.richeninfo.pboss.ui.SplashActivity");
        startActivity(intent);
    }
}
