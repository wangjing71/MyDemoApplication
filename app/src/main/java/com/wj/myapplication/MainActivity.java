package com.wj.myapplication;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.gyf.barlibrary.ImmersionBar;


public class MainActivity extends BaseActivity {

    private View statbarHeight;
    private LinearLayout toolBars;
    private RecyclerView recyclerView;
    public MyAdapter businessSelectAdapter;

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
        statbarHeight = findViewById(R.id.statbarheight);
        ImmersionBar.setStatusBarView(this,statbarHeight);
        toolBars = findViewById(R.id.toolbars);
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    protected void initData() {
        businessSelectAdapter = new MyAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(businessSelectAdapter);
    }

    @Override
    protected void setEvent() {
    }

    private void doSomeThing() {

    }
}
