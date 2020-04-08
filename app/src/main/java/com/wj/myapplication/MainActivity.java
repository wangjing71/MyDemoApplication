package com.wj.myapplication;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.angcyo.tablayout.DslTabLayout;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private AppsAdapter appsAdapter;
    private DslTabLayout dslTabLayout;
    private LinearLayout barLayout;
    private boolean iScroll = false;
    private Long time;
    private LinearLayoutManager manager;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        dslTabLayout = findViewById(R.id.dsl_tabLayout);
        barLayout = findViewById(R.id.barLayout);
    }

    @Override
    protected void initData() {
        appsAdapter = new AppsAdapter(this);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(appsAdapter);

    }

    @Override
    protected void setEvent() {
        dslTabLayout.getTabLayoutConfig().setOnSelectIndexChange(new Function3<Integer, List<Integer>, Boolean, Unit>() {
            @Override
            public Unit invoke(Integer fromIndex, List<Integer> selectIndexList, Boolean reselect) {
                int toIndex = selectIndexList.get(0);
                if (!iScroll) {
                    time = System.currentTimeMillis();
                    smoothToPosition(toIndex);
                }
                return null;
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == 1) {
                    iScroll = true;
                } else if (newState == 0) {
                    iScroll = false;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;

                    int firstItemPosition = linearManager.findFirstVisibleItemPosition();
                    int lastItemPosition = recyclerView.getAdapter().getItemCount();

                    if (System.currentTimeMillis() - time > 1500) {
                        dslTabLayout.setCurrentItem(firstItemPosition, true);
                    }

                    View lastView = linearManager.findViewByPosition(lastItemPosition - 1);
//                    if (lastView != null) {
//                        int padBottom = ScreenUtils.getScreenHeight(MainActivity.this) - lastView.getHeight() - dslTabLayout.getHeight() - barLayout.getHeight();
//                        RecyclerView.LayoutParams parms = (RecyclerView.LayoutParams) lastView.getLayoutParams();
//                        parms.bottomMargin = padBottom;
//                        lastView.setLayoutParams(parms);
//                    }
                }
            }
        });
    }

    /**
     * 目标项是否在最后一个可见项之后
     */
    private boolean mShouldScroll;
    /**
     * 记录目标项位置
     */
    private int mToPosition;

    /**
     * 滑动到指定位置
     */
    private void smoothMoveToPosition(RecyclerView mRecyclerView, final int position) {
        // 第一个可见位置
        int firstItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(0));
        // 最后一个可见位置
        int lastItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1));
        if (position < firstItem) {
            // 第一种可能:跳转位置在第一个可见位置之前，使用smoothScrollToPosition
            mRecyclerView.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            // 第二种可能:跳转位置在第一个可见位置之后，最后一个可见项之前
            int movePosition = position - firstItem;
            if (movePosition >= 0 && movePosition < mRecyclerView.getChildCount()) {
                int top = mRecyclerView.getChildAt(movePosition).getTop();
                // smoothScrollToPosition 不会有效果，此时调用smoothScrollBy来滑动到指定位置
                mRecyclerView.smoothScrollBy(0, top);
            }
        } else {
            // 第三种可能:跳转位置在最后可见项之后，则先调用smoothScrollToPosition将要跳转的位置滚动到可见位置
            // 再通过onScrollStateChanged控制再次调用smoothMoveToPosition，执行上一个判断中的方法
            mRecyclerView.smoothScrollToPosition(position);
            mToPosition = position;
            mShouldScroll = true;

        }
    }

    private void smoothToPosition(int position) {
        LinearSmoothScroller s3 = new TopSmoothScroller(MainActivity.this);
        s3.setTargetPosition(position);
        manager.startSmoothScroll(s3);
    }
}
