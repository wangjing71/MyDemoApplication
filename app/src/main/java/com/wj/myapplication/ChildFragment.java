package com.wj.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class ChildFragment extends BaseFragment {

    private String pageTitle;
    private Button btn;

    public ChildFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getArguments() != null) {
            pageTitle =  getArguments().getString("pageTitle");
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int setContentViewId() {
        return R.layout.my_child;
    }

    @Override
    public void initView(View root) {
        btn = root.findViewById(R.id.button);
    }

    @Override
    public void initData() {
        btn.setText(pageTitle);
    }

    @Override
    public void setEvent() {
    }
}
