package com.wj.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by Administrator on 2018/1/4.
 */

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        initView();
        initData();
        setEvent();
    }

    protected abstract int setLayoutId();

    protected void initView() {
    }

    protected void initData() {
    }

    protected void setEvent() {
    }
}