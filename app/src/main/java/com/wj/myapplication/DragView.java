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

    public DragView(Context context) {
        super(context);
    }

    public DragView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DragView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    int lastX, lastY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        Log.i("====", rawX + "");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = rawX;
                lastY = rawY;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = rawX - lastX;
                int offsetY = rawY - lastY;
//                layout(getLeft()+offsetX,
//                        getTop()+offsetY,
//                        getRight()+offsetX,
//                        getBottom()+offsetY);

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
