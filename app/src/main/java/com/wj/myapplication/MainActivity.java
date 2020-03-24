package com.wj.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends BaseActivity {
    private LinearLayout content;
    private UMExpandLayout umExpandLayout;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        content = findViewById(R.id.parent);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                umExpandLayout = (UMExpandLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.items_layout,null,false);
                View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.item1, null, false);
                umExpandLayout.addChildView(view1);
                View view2 = LayoutInflater.from(MainActivity.this).inflate(R.layout.item1, null, false);
                umExpandLayout.addChildView(view2);
                View view3 = LayoutInflater.from(MainActivity.this).inflate(R.layout.item1, null, false);
                umExpandLayout.addChildView(view3);

                content.addView(umExpandLayout,3);
            }
        });


        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                umExpandLayout.toggleExpand();
            }
        });
    }
}
