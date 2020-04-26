package com.wj.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * author wangjing
 * Date 2020/4/26
 * Description
 */
public class MyButton extends android.support.v7.widget.AppCompatButton {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("====MyRelativeLayout", "====ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("====MyRelativeLayout", "Raw:" + event.getRawX() + "_" + event.getRawY());
                Log.i("====MyRelativeLayout", event.getX() + "_" + event.getY());
                break;
            case MotionEvent.ACTION_UP:
                Log.i("====MyRelativeLayout", "====ACTION_UP");
                break;
        }

        return false;
    }
}
