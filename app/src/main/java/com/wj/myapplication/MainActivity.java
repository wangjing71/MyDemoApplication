package com.wj.myapplication;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends BaseActivity {

    private MyButton button;
    private MyRelativeLayout parent;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        button = findViewById(R.id.button);
        parent = findViewById(R.id.parent);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSomeThing();
            }
        });

        parent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("====MyRelativeLayout", "====onTouch");
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
        });
    }

    private void doSomeThing() {
        Log.i("====", "按钮被点击了");
    }
}
