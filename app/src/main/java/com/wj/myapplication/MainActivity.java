package com.wj.myapplication;

import android.os.Bundle;


public class MainActivity extends BaseActivity {
    private PagerSlidingTabStrip myTab;

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
        myTab = findViewById(R.id.myTab);
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
