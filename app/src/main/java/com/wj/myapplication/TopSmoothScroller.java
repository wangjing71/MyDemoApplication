package com.wj.myapplication;

import android.content.Context;

import androidx.recyclerview.widget.LinearSmoothScroller;

/**
 * author wangjing
 * Date 2020/4/8
 * Description
 */
public class TopSmoothScroller extends LinearSmoothScroller {
    public TopSmoothScroller(Context context) {
        super(context);
    }


    @Override
    protected int getHorizontalSnapPreference() {
        return SNAP_TO_START;//具体见源码注释
    }

    @Override
    protected int getVerticalSnapPreference() {
        return SNAP_TO_START;//具体见源码注释
    }
}