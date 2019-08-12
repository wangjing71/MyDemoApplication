package com.wj.myapplication.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.wj.myapplication.R;

import butterknife.ButterKnife;


public abstract class BaseActivity extends AppCompatActivity {


    protected RxPermissions rxPermissions;
    private View barView;
    public Gson gson = new Gson();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        rxPermissions = new RxPermissions(this);
        barView = findViewById(R.id.barView);
        ImmersionBar.setStatusBarView(this, barView);
        initData();
        setEvent();
    }

    protected abstract int setLayoutId();

    protected abstract void initData();

    protected void setEvent() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}