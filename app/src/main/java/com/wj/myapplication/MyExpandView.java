package com.wj.myapplication;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
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
    private android.os.Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
        }
    };

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
        expandConent.setVisibility(GONE);

        titleParent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                expandParent.toggleExpand();
            }
        });
    }

    /**
     * @param isExpand 初始状态是否折叠
     */
    public void initExpand(boolean isExpand) {
        expandParent.initExpand(isExpand);
    }

    /**
     * 折叠view
     */
    public void collapse() {
        expandParent.collapse();
    }


    /**
     * 展开view
     */
    public void expand() {
        expandParent.expand();
        expandConent.setVisibility(VISIBLE);
    }

    public void addExpandView(View chindView){
        expandConent.addView(chindView);
        expandParent.reSetViewDimensions();
    }

    /**
     * 展开view
     */
    public void expandDelayed(long delayMillis) {
        expandParent.expandDelayed(delayMillis);
        expandConent.setVisibility(VISIBLE);
    }
}
