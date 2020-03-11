package com.wj.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author wangjing
 * Date 2020/3/10
 * Description
 */
public class ChildFragment extends BaseLazyFragment {
    private RecyclerView recyclerView;

    @Override
    public int setContentViewId() {
        return R.layout.child_fragment;
    }

    public void initView(View view) {
        recyclerView = view.findViewById(R.id.mRecyclerView);
    }

    public void initData() {
        Log.i("====","initData1");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MyTextAdapter(getContext()));
    }

    public void setEvent() {

    }
}
