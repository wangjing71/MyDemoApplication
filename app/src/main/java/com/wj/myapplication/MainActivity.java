package com.wj.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends BaseActivity {
    private ArrayList<Fragment> myPage = new ArrayList<>();
    private ViewPager viewParent;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        viewParent = findViewById(R.id.viewpager);
    }

    @Override
    protected void initData() {
        myPage.add(new ChildFragment());
        myPage.add(new ChildFragment());
        myPage.add(new ChildFragment());
        viewParent.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
    }

    @Override
    protected void setEvent() {

    }

    class MyPageAdapter extends FragmentPagerAdapter{

        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return myPage.get(i);
        }

        @Override
        public int getCount() {
            return myPage.size();
        }
    }
}
