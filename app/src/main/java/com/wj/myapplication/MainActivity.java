package com.wj.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity {

    private Button button;
    private AVLoadingIndicatorView avLoadingIndicatorView;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        button = findViewById(R.id.button);
        avLoadingIndicatorView = findViewById(R.id.loading);
    }

    @Override
    protected void initData() {
        avLoadingIndicatorView.setIndicator(new LineSpinFadeLoaderIndicator());
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
