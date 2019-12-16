package com.wj.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.gyf.immersionbar.ImmersionBar;
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
        ImmersionBar
                .with(this)
                .navigationBarColorTransform(R.color.orange)
//                .navigationBarDarkIcon(true) //导航栏图标是深色，不写默认为亮色
//                .fullScreen(true)
                .navigationBarAlpha(1.0f)  //导航栏透明度，不写默认0.0F
                .init();
        rxPermissions = new RxPermissions(this);
        barView = findViewById(R.id.barView);
        ImmersionBar.setStatusBarView(this, barView);

        initView();
        initData();
        setEvent();
    }

    protected abstract int setLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void setEvent();

}