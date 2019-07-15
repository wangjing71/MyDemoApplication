package com.wj.myapplication;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity {

    private Button add,delete;
    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
        mRecyclerView = findViewById(R.id.mRecyclerView);
    }

    @Override
    protected void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        myAdapter = new MyAdapter(this);
        mRecyclerView.setAdapter(myAdapter);
    }

    @Override
    protected void setEvent() {

    }
}
