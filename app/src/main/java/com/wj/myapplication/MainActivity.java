package com.wj.myapplication;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends BaseActivity {

    private Button add,delete;
    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;
    private ArrayList<String> dataList = new ArrayList<>();

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
        for (int i = 0; i < 15; i++) {
            dataList.add("条目_"+i);
        }

        GridLayoutManager linearLayoutManager = new GridLayoutManager(this,3);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        myAdapter = new MyAdapter(this);
        myAdapter.setDataList(dataList);
        mRecyclerView.setAdapter(myAdapter);
    }

    @Override
    protected void setEvent() {

    }
}
