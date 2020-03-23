package com.wj.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity1 extends BaseActivity {
    private ExpandView expandView;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main_1;
    }

    @Override
    protected void initView() {
        expandView = findViewById(R.id.expandView);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandView.collapse();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandView.expand();
            }
        });
    }

}
