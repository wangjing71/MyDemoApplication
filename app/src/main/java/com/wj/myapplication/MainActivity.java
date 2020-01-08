package com.wj.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.gyf.immersionbar.ImmersionBar;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;


public class MainActivity extends BaseActivity {
    private int mOffset = 0;
    private int mScrollY = 0;

    private int imageHeight;

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
        ImmersionBar.with(this).init();
    }

    @Override
    protected void initData() {

        //状态栏透明和间距处理
//        StatusBarUtil.immersive(this);
//        StatusBarUtil.setPaddingSmart(this, toolbar);
//        StatusBarUtil.setMargin(this, findViewById(R.id.header));

        final View parallax = findViewById(R.id.parallax);
        parallax.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                imageHeight = parallax.getHeight();
            }
        });
        final RefreshLayout refreshLayout = findViewById(R.id.refreshLayout);


        refreshLayout.setOnMultiPurposeListener(new SimpleMultiPurposeListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(3000);
            }

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(2000);
            }

            @Override
            public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
                Log.i("====offset", offset + "");
                mOffset = offset / 2;
//                parallax.setTranslationY(mOffset - mScrollY);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) parallax.getLayoutParams();
                params.height = imageHeight + offset;
                parallax.setLayoutParams(params);
            }
        });
    }

    @Override
    protected void setEvent() {
    }

}
