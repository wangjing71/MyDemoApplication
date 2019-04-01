package com.wj.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gyf.barlibrary.ImmersionBar;


public class MainActivity extends BaseActivity {

    private View barView;
    private Button button1,button2,button3;

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
        barView = findViewById(R.id.barView);
        ImmersionBar.setStatusBarView(this,barView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doGet();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPost();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doDownload();
            }
        });
    }

    private void doDownload() {

    }

    private void doPost() {

    }

    private void doGet() {

    }

}
