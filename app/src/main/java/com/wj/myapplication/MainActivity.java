package com.wj.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity {

    private MyExpandView umExpandLayout;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            umExpandLayout.expand();
        }
    };

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        umExpandLayout = findViewById(R.id.mMyExpandView1);
        umExpandLayout.initExpand(false);
    }

    @Override
    protected void initData() {
        View child1 = LayoutInflater.from(this).inflate(R.layout.chindviewlauouit,null,false);
        umExpandLayout.addExpandView(child1);
        View child2 = LayoutInflater.from(this).inflate(R.layout.chindviewlauouit,null,false);
        umExpandLayout.addExpandView(child2);

        handler.sendEmptyMessageDelayed(0,800);
    }

    @Override
    protected void setEvent() {

    }

    private void doSomeThing() {

    }
}
