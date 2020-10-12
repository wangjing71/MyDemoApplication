package com.wj.myapplication;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * author wangjing
 * Date 2020/8/24
 * Description
 */
public class MyView extends View {
    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        showOrhide();
    }

    private void showOrhide() {
        postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("====","showOrhide");
                showOrhide();
            }
        },1000);
    }
}
