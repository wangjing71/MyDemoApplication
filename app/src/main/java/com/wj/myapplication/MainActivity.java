package com.wj.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends BaseActivity {
    private LinearLayout parent;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        parent = findViewById(R.id.parent);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view2 = LayoutInflater.from(MainActivity.this).inflate(R.layout.item1, null, false);
                myExpandView.addExpandView(view2);
//                myExpandView.expandDelayed(300);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

}
