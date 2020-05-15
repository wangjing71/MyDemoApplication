package com.wj.myapplication;


import com.wj.myapplication.vp.MyTvPageAdapter;
import com.wj.myapplication.vp.YViewPager;

public class MainActivity extends BaseActivity {
    private YViewPager viewPager;
    private MyTvPageAdapter adapter;

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
        adapter = new MyTvPageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void setEvent() {

    }
}
