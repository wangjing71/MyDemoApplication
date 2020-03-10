package com.wj.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author wangjing
 * Date 2020/3/10
 * Description
 */
public class ChildFragment extends Fragment {

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

    }

    private void initData() {

    }

    private void setEvent() {

    }
}
