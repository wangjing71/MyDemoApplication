package com.wj.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author： Shine
 * @date：2013-8-21 下午2:39:20
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(setContentViewId(), null);
        initView(root);
        initData();
        setEvent();
        return root;
    }

    public abstract int setContentViewId();

    public abstract void initView(View root);

    public abstract void initData();

    public void setEvent() {
    }
}
 