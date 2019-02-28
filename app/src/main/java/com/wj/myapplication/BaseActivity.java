package com.wj.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tbruyelle.rxpermissions2.RxPermissions;


/**
 * Created by Administrator on 2018/1/4.
 */

public abstract class BaseActivity extends AppCompatActivity {


    protected RxPermissions rxPermissions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        rxPermissions = new RxPermissions(this);
        initView();
        initData();
        setEvent();
    }

    protected abstract int setLayoutId();
    protected abstract void initView() ;
    protected abstract void initData() ;
    protected abstract void setEvent() ;
}