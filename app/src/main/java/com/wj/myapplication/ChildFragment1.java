package com.wj.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
public class ChildFragment1 extends BaseLazyFragment {

    @Override
    public int setContentViewId() {
        return R.layout.child_fragment_1;
    }

    public void initView(View view) {
    }

    public void initData() {
        Log.i("====","initData2");
    }

    public void setEvent() {
    }
}
