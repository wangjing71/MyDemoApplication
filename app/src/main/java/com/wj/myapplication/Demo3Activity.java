package com.wj.myapplication;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class Demo3Activity extends BaseActivity {
    private RecyclerView recyclerView;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_demo3;
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recyclerView);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void initData() {
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new MyTextAdapter(this));
    }

    @Override
    protected void setEvent() {

    }
}
