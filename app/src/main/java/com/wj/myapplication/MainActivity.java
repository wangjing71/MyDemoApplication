package com.wj.myapplication;


import android.widget.Toast;

import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends BaseActivity {

    private ViewPager2 viewPager2;
    private MyAdapter myAdapter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        viewPager2 = findViewById(R.id.view_pager);
    }

    @Override
    protected void initData() {
        myAdapter = new MyAdapter();
        myAdapter.setData(null);
        viewPager2.setAdapter(myAdapter);
    }

    @Override
    protected void setEvent() {
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
