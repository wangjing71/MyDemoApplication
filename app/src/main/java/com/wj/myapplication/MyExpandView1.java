package com.wj.myapplication;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * author wangjing
 * Date 2020/3/20
 * Description
 */
public class MyExpandView1 extends LinearLayout {
    private ImageView icon;
    private LinearLayout content;

    public MyExpandView1(Context context) {
        super(context);
        init();
    }

    public MyExpandView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyExpandView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.my_expand_view_1, this);
        icon = findViewById(R.id.icon);
        content = findViewById(R.id.content);

        icon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                HiddenAnimUtils.newInstance(getContext(),content,icon,77).toggle();
            }
        });
    }
}
