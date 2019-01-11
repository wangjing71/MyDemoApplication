package com.wj.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;


public class MainActivity extends BaseActivity {

    private View statbarHeight;
    private LinearLayout toolBars;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    public MyAdapter businessSelectAdapter;
    private SmartRefreshLayout smartRefreshLayout;

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
        smartRefreshLayout = findViewById(R.id.refreshLayout);
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
                    if (dis > 1000) {
                        dis = 1000;
                    }
                    toolBars.getBackground().setAlpha(255 * dis / 1000);
                    statbarHeight.getBackground().setAlpha(255 * dis / 1000);
                    ImmersionBar.setStatusBarView(MainActivity.this, statbarHeight);
                }
            }
        });

        smartRefreshLayout.setOnRefreshLoadMoreListener(new OnMultiPurposeListener() {
            @Override
            public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {

            }

            @Override
            public void onHeaderReleased(RefreshHeader header, int headerHeight, int maxDragHeight) {

            }

            @Override
            public void onHeaderStartAnimator(RefreshHeader header, int headerHeight, int maxDragHeight) {

            }

            @Override
            public void onHeaderFinish(RefreshHeader header, boolean success) {

            }

            @Override
            public void onFooterMoving(RefreshFooter footer, boolean isDragging, float percent, int offset, int footerHeight, int maxDragHeight) {

            }

            @Override
            public void onFooterReleased(RefreshFooter footer, int footerHeight, int maxDragHeight) {

            }

            @Override
            public void onFooterStartAnimator(RefreshFooter footer, int footerHeight, int maxDragHeight) {

            }

            @Override
            public void onFooterFinish(RefreshFooter footer, boolean success) {

            }

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }

            @Override
            public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
               if(newState == RefreshState.None){
                   Log.i("====","1111");
                   toolBars.setVisibility(View.VISIBLE);
               }else{
                   Log.i("====","2222");
                   toolBars.setVisibility(View.GONE);
               }
            }
        });
    }
}
