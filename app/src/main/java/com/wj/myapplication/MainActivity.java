package com.wj.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gyf.barlibrary.ImmersionBar;


public class MainActivity extends BaseActivity {

    private View statbarHeight;

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
        statbarHeight = findViewById(R.id.statbarheight);
        ImmersionBar.setStatusBarView(this,statbarHeight);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
    }

    private void doSomeThing() {

    }
}
