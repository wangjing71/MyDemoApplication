package com.wj.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity {

    private UMExpandLayout umExpandLayout;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        umExpandLayout = findViewById(R.id.setting_about_content);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
        findViewById(R.id.zhankai).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                umExpandLayout.expand();
            }
        });

        findViewById(R.id.zhedie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                umExpandLayout.collapse();
            }
        });
    }

    private void doSomeThing() {

    }
}
