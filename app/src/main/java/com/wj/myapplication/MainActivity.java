package com.wj.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;


public class MainActivity extends BaseActivity {
    private PagerSlidingTabStrip myTab;
    private ViewPager mViewPager;
    private ArrayList<String> titles;
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
        titles = new ArrayList<>();

        titles.add("基础套餐");
        titles.add("自有业务");
        titles.add("群组业务");
        titles.add("其他业务");

        for (int i = 0; i < 4; i++) {
            ChildFragment childFragment = new ChildFragment();
            Bundle bundle = new Bundle();
            bundle.putString("pageTitle", "页面 "+ i);
            childFragment.setArguments(bundle);
            fragList.add(childFragment);
        }

        mViewPager.setAdapter(new MyBusinessAdapter(getSupportFragmentManager()));

        myTab.setmViewPager(mViewPager);


    }

    @Override
    protected void setEvent() {
    }

    class MyBusinessAdapter extends FragmentPagerAdapter {

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        public MyBusinessAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragList.get(position);
        }

        @Override
        public int getCount() {
            return fragList.size();
        }
    }

}
