package com.wj.myapplication;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Demo1Activity extends BaseActivity {

    private RecyclerView recyclerView;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_demo1;
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    protected void initData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyTextAdapter(this));
    }

    @Override
    protected void setEvent() {

    }
}
