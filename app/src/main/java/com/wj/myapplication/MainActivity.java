package com.wj.myapplication;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends BaseActivity {

    private TextView wenzi;
    private RelativeLayout parent;

    private boolean mBackEnable = false;
    private boolean mIsBtnBack = false;
    private int rootBottom = Integer.MIN_VALUE;

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
        wenzi = findViewById(R.id.wenzi);
        parent = findViewById(R.id.parent);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
        parent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                parent.getGlobalVisibleRect(r);
                // 进入Activity时会布局，第一次调用onGlobalLayout，先记录开始软键盘没有弹出时底部的位置
                if (rootBottom == Integer.MIN_VALUE) {
                    rootBottom = r.bottom;
                    return;
                }
                // adjustResize，软键盘弹出后高度会变小
                if (r.bottom < rootBottom) {
                    mBackEnable = false;
                    Log.i("====","1111");
                } else {
                    Log.i("====","2222");
                    mBackEnable = true;
                }
            }
        });
    }

}
