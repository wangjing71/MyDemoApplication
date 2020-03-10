package com.wj.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author wangjing
 * Date 2020/3/10
 * Description
 */
public class ChildFragment extends Fragment {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.child_fragment,null,false);
        initView(view);
        initData();
        setEvent();
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.mRecyclerView);
    }

    private void initData() {
        recyclerView.setAdapter(new MyTextAdapter(getContext()));
    }

    private void setEvent() {

    }
}
