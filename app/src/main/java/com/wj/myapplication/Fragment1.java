package com.wj.myapplication;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

/**
 * author wangjing
 * Date 2018/12/24
 * Description
 */
public class Fragment1 extends BaseFragment {
    private RecyclerView recyclerView;

    public Fragment1() {
    }

    public int setContentViewId() {
        return R.layout.business_item1;
    }

    @Override
    public void initView(View root) {
        recyclerView = root.findViewById(R.id.recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void initData() {
    }

    @Override
    public void setEvent() {
    }
}
