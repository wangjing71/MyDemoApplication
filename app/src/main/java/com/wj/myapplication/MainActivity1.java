package com.wj.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity1 extends BaseActivity {

    private LinearLayout parent;
    private MyExpandView1 myExpandView1;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main_1;
    }

    @Override
    protected void initView() {
        parent = findViewById(R.id.parent);
    }

    @Override
    protected void initData() {
        myExpandView1 = (MyExpandView1) LayoutInflater.from(MainActivity1.this).inflate(R.layout.item_view_1, null, false);
        myExpandView1.setExpand(false);
    }

    @Override
    protected void setEvent() {
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.addView(myExpandView1);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = new TextView(MainActivity1.this);
                textView.setText("12345456");
                myExpandView1.addChildView(textView);
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity1.this, myExpandView1.getContentHeight() + "_", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
