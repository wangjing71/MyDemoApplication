package com.wj.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends BaseActivity {

    private TextView wenzi;
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
        wenzi = findViewById(R.id.wenzi);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
    }

}
