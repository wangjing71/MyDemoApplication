package com.wj.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;

import com.gyf.barlibrary.ImmersionBar;
import com.gyf.barlibrary.OnKeyboardListener;
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
        ImmersionBar.with(this)
                .keyboardEnable(false)  //true 键盘会把底部布局推上去 false 则不会
                .setOnKeyboardListener(new OnKeyboardListener() {    //软键盘监听回调
                    @Override
                    public void onKeyboardChange(boolean isPopup, int keyboardHeight) {
                        keyBoardChange(isPopup, keyboardHeight);
                    }
                })
                .init();  //必须调用方可沉浸式
        rxPermissions = new RxPermissions(this);
        initView();
        initData();
        setEvent();
    }

    protected void keyBoardChange(boolean isPopup, int keyboardHeight) {
    }

    protected abstract int setLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void setEvent();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }
}