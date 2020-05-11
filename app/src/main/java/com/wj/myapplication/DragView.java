package com.wj.myapplication;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * author wangjing
 * Date 2020/5/11
 * Description
 */
public class DragView extends RelativeLayout {

    private boolean isLimit = true; //是否限制屏幕中可见
    private int mScreenWidth;

    public DragView(Context context) {
        super(context);
        init();
    }

    public DragView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DragView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mScreenWidth = ScreenUtils.getScreenWidth(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(150, 150);
        setLayoutParams(params);
    }

    int lastX, lastY;

    int lastLeft = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = rawX;
                lastY = rawY;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = rawX - lastX;
                int offsetY = rawY - lastY;
                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);
                lastX = rawX;
                lastY = rawY;
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    public static void addDragView(Context context, ViewGroup group, @LayoutRes int layoutResID) {
        View view = LayoutInflater.from(context).inflate(layoutResID, null, false);
        if (view instanceof DragView) {
            group.addView(view);
        } else {
            throw new RuntimeException("父布局必须是 DragView");
        }
    }
}
