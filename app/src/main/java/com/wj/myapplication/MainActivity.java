package com.wj.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends BaseActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private ImageView iv;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        iv = findViewById(R.id.imageView);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void setEvent() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setColorFilter(Color.parseColor("#FF4081"));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setColorFilter(Color.parseColor("#3390E8"));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setColorFilter(Color.parseColor("#F8CE40"));
            }
        });

    }
}
