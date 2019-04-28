package com.wj.myapplication;

import android.os.Bundle;
import android.support.v4.view.ViewPager;


public class MainActivity extends BaseActivity {
    private PagerSlidingTabStrip myTab;
    private ViewPager mViewPager;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        myTab = findViewById(R.id.myTab);
        mViewPager = findViewById(R.id.mViewPager);
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
