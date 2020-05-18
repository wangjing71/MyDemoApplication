package com.wj.myapplication.vp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * author wangjing
 * Date 2020/5/18
 * Description
 */
public class MyTextRollView extends LinearLayout {
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
}
