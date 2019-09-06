package com.wj.myapplication;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * author wangjing
 * Date 2019/9/6
 * Description 可移动的View 第一种实现方案
 */
public class MyView1 extends View {
    private int lastX, lastY;

    public MyView1(Context context) {
        super(context);
    }

    public MyView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

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
                Log.i("===", offsetX + "_" + offsetY);
                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                lastX = rawX;
                lastY = rawY;
                break;
        }
        return true;
    }
}
