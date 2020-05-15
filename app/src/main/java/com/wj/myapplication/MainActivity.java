package com.wj.myapplication;

import android.content.Context;
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
        adapter = new WelcomeAdPagerAdapter(this);
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void setEvent() {

    }

    class WelcomeAdPagerAdapter extends YPagerAdapter {

        private Context context;

        public WelcomeAdPagerAdapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, final int position) {
            View item = LayoutInflater.from(context).inflate(R.layout.view_start_page_1, null, false);
            container.addView(item);
            return item;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
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
