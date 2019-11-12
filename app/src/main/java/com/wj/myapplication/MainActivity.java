package com.wj.myapplication;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity {
    private RecyclerView recyclerView1;
    private MyAdapter adapter1;



    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        recyclerView1 = findViewById(R.id.mRecyclerView1);
    }

    @Override
    protected void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(manager);
        adapter1 = new MyAdapter(this);
        recyclerView1.setAdapter(adapter1);

    }

    @Override
    protected void setEvent() {
    }

    private void doSomeThing() {

    }
}
