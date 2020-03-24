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

    }

    @Override
    protected void setEvent() {
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myExpandView1 = (MyExpandView1) LayoutInflater.from(MainActivity1.this).inflate(R.layout.item_view_1, null, false);
//                myExpandView1.setExpand(false);
                parent.addView(myExpandView1,3);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View item = LayoutInflater.from(MainActivity1.this).inflate(R.layout.item1,null,false);
                myExpandView1.addChildView(item);
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
