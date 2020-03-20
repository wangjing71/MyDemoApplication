package com.wj.myapplication;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * author wangjing
 * Date 2020/3/20
 * Description
 */
public class MyExpandView extends LinearLayout {
    private LinearLayout titleParent;
    private UMExpandLayout expandParent;
    private LinearLayout expandConent;

    public MyExpandView(Context context) {
        super(context);
        init();
    }

    public MyExpandView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyExpandView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.my_expand_view, this);
        titleParent = findViewById(R.id.title_parent);
        expandParent = findViewById(R.id.expand_layout_parent);
        expandConent = findViewById(R.id.expand_layout_content);
    }
}
