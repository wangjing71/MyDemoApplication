package com.wj.myapplication;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * author wangjing
 * Date 2020/3/10
 * Description
 */
public class StickyNavLayout extends LinearLayout {
    public StickyNavLayout(Context context) {
        super(context);
    }

    public StickyNavLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StickyNavLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
