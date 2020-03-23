package com.wj.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends BaseActivity {
    private LinearLayout parent;
    private Button button;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        parent = findViewById(R.id.parent);
        button = findViewById(R.id.button);
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
    }

    private void doSomeThing() {
        for (int i = 0; i < 4; i++) {
            MyExpandView view1 = (MyExpandView) LayoutInflater.from(this).inflate(R.layout.items_layout, null, false);
            view1.initExpand(false);
            View view2 = LayoutInflater.from(this).inflate(R.layout.chindviewlauouit, null, false);
            view1.addExpandView(view2);
            parent.addView(view1);
            view1.expandDelayed(200 + 500 * i);
        }
    }
}
