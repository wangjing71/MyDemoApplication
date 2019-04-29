package com.wj.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends BaseActivity {
    private PagerSlidingTabStrip myTab;
    private ViewPager mViewPager;
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragList;
    private Button btn1,btn2;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        myTab = findViewById(R.id.myTab);
        mViewPager = findViewById(R.id.mViewPager);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
    }

    @Override
    protected void initData() {
        fragList = new ArrayList<>();
        titles = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            titles.add("条目 " + i);
            ChildFragment childFragment = new ChildFragment();
            Bundle bundle = new Bundle();
            bundle.putString("pageTitle", "页面 "+ i);
            childFragment.setArguments(bundle);
            fragList.add(childFragment);
        }

        mViewPager.setAdapter(new MyBusinessAdapter(getSupportFragmentManager()));

        myTab.setViewPager(mViewPager);
    }

    @Override
    protected void setEvent() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTab.scrollBy(10,0);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTab.scrollBy(-10,0);
            }
        });
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
