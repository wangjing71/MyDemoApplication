package com.wj.myapplication;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recyclerview);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
    }

}
