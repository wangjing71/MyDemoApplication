package com.wj.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;


public class MainActivity extends BaseActivity {
    private PagerSlidingTabStrip myTab;
    private ViewPager mViewPager;
    private ArrayList<Fragment> fragList;

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
        fragList = new ArrayList<>();
    }

    @Override
    protected void setEvent() {
    }

    private void doSomeThing() {

    }
}
