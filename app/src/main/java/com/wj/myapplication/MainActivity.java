package com.wj.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity extends BaseActivity {
    private LinearLayout parent;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        parent = findViewById(R.id.parent);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 4; i++) {
            MyExpandView view1 = (MyExpandView) LayoutInflater.from(this).inflate(R.layout.items_layout, null, false);
            view1.initExpand(false);
            view1.expandDelayed(2000);
            View view2 = LayoutInflater.from(this).inflate(R.layout.chindviewlauouit, null, false);
            view1.addExpandView(view2);
            parent.addView(view1);
        }
    }

    @Override
    protected void setEvent() {

    }

    private void doSomeThing() {

    }
}
