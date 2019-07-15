package com.wj.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity {

    private Button add,delete;

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
        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {

    }
}
