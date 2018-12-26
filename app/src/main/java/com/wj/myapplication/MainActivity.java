package com.wj.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MainActivity extends BaseActivity {

    private Button button;
    private ImageView backgroind;
    private RelativeLayout parent;
    private int count = 0;

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
        button = findViewById(R.id.button);
        backgroind = findViewById(R.id.background);
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
    }

    private void doSomeThing() {
        count=count+10;
        if(count<=255){
            parent.getBackground().setAlpha(255-count);
        }
    }
}
