package com.wj.myapplication;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wj.myapplication.vp.YPagerAdapter;
import com.wj.myapplication.vp.YViewPager;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private YViewPager viewPager;
    private WelcomeAdPagerAdapter adapter;
    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.viewpager);
    }

    @Override
    protected void initData() {
        ArrayList<View> viewList = new ArrayList<>();
        View page1 = LayoutInflater.from(this).inflate(R.layout.view_start_page_1,null,false);
        View page2 = LayoutInflater.from(this).inflate(R.layout.view_start_page_1,null,false);
        View page3 = LayoutInflater.from(this).inflate(R.layout.view_start_page_1,null,false);
        viewList.add(page1);
        viewList.add(page2);
        viewList.add(page3);
        adapter = new WelcomeAdPagerAdapter(viewList);
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void setEvent() {

    }

    class WelcomeAdPagerAdapter extends YPagerAdapter {

        private ArrayList<View> viewList;

        public WelcomeAdPagerAdapter(ArrayList<View> viewList) {
            this.viewList = viewList;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, final int position) {
            View item = viewList.get(position);
            container.addView(item);
            return item;
        }

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
