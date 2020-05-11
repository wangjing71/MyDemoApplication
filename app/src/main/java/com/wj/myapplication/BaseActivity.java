package com.wj.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.gyf.barlibrary.ImmersionBar;
import com.tbruyelle.rxpermissions2.RxPermissions;


/**
 * Created by Administrator on 2018/1/4.
 */

public abstract class BaseActivity extends AppCompatActivity {


    protected RxPermissions rxPermissions;
    private View barView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        ImmersionBar.with(this).init();
        rxPermissions = new RxPermissions(this);
        barView = findViewById(R.id.barView);
        ImmersionBar.setStatusBarView(this, barView);
        barView.post(new Runnable() {
            @Override
            public void run() {
                Log.i("====",barView.getWidth()+"");
            }
        });
        initView();
        initData();
        setEvent();
    }

    protected abstract int setLayoutId();
    protected abstract void initView() ;
    protected abstract void initData() ;
    protected abstract void setEvent() ;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }
}