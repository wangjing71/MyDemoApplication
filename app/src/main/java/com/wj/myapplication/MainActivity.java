package com.wj.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.gyf.barlibrary.ImmersionBar;


public class MainActivity extends BaseActivity {

    private View statbarHeight;
    private LinearLayout toolBars;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
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
        ImmersionBar.setStatusBarView(this, statbarHeight);
        toolBars = findViewById(R.id.toolbars);
        recyclerView = findViewById(R.id.recyclerView);
        toolBars.getBackground().setAlpha(0);
        statbarHeight.getBackground().setAlpha(0);
    }

    @Override
    protected void initData() {
        businessSelectAdapter = new MyAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(businessSelectAdapter);
    }

    @Override
    protected void setEvent() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                View fitstView = linearLayoutManager.findViewByPosition(0);
                if (fitstView != null) {
                    int dis = (int) Math.abs(fitstView.getY());
                    Log.i("====", dis + "");
                    if (dis > 1000) {
                        dis = 1000;
                    }
                    toolBars.getBackground().setAlpha(255 * dis / 1000);
                    statbarHeight.getBackground().setAlpha(255 * dis / 1000);
                    ImmersionBar.setStatusBarView(MainActivity.this, statbarHeight);
                }
            }
        });
    }
}
