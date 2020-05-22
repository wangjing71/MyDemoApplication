package com.wj.myapplication;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * author wangjing
 * Date 2019/9/30
 * Description
 */
public class AAA extends BaseActivity {
    private Button button;
    @Override
    protected int setLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getLayoutParams();
                event.getAction();
                return false;
            }
        });
    }

    @Override
    protected void setEvent() {

    }

    public static void main(String[] args) {

    }
}
