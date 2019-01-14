package com.wj.myapplication;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;


public class MainActivity extends BaseActivity {

    private RelativeLayout parent;
    private int keyHeight = 0;
    private RelativeLayout bot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        parent = findViewById(R.id.parent);
        keyHeight = getWindowManager().getDefaultDisplay().getHeight() / 3;
        bot = findViewById(R.id.bot);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
        parent.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > keyHeight)) {
                    Log.i("====", "1111");
                } else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom > keyHeight)) {
                    Log.i("====", "2222");
                }
            }
        });

        bot.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("ACTION_DOWN", "ACTION_DOWN");
                        bot.setBackgroundColor(Color.parseColor("#ff00ff"));
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.i("ACTION_MOVE", event.getRawX() + "_" + event.getRawY());
                        break;
                    case MotionEvent.ACTION_UP:
                        bot.setBackgroundColor(getColor(R.color.colorPrimary));
                        Log.i("ACTION_UP", "ACTION_UP");
                        break;
                }

                return false;
            }
        });
    }

}
