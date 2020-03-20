package com.wj.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity {

    private MyExpandView umExpandLayout;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        umExpandLayout = findViewById(R.id.mMyExpandView);
    }

    @Override
    protected void initData() {
        View child1 = LayoutInflater.from(this).inflate(R.layout.chindviewlauouit,null,false);
        umExpandLayout.addExpandView(child1);
        View child2 = LayoutInflater.from(this).inflate(R.layout.chindviewlauouit,null,false);
        umExpandLayout.addExpandView(child2);
    }

    @Override
    protected void setEvent() {

    }

    private void doSomeThing() {

    }
}
