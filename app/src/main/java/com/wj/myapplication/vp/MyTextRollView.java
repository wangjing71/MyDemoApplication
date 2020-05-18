package com.wj.myapplication.vp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * author wangjing
 * Date 2020/5/18
 * Description
 */
public class MyTextRollView extends LinearLayout {
    private ViewPager viewPager;
    private ArrayList<String> dataStrList;

    public void setDataStrList(ArrayList<String> dataStrList) {
        this.dataStrList = dataStrList;
    }

    public MyTextRollView(Context context) {
        super(context);
        init();
    }

    public MyTextRollView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextRollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        viewPager = new ViewPager(getContext());
        LinearLayout.LayoutParams vp_parms = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        viewPager.setLayoutParams(vp_parms);
        addView(viewPager);
    }
}
