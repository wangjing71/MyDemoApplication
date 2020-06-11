package com.wj.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;


public class MainActivity extends BaseActivity {

//    private Button button;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
//        button = findViewById(R.id.button);
    }

    @Override
    protected void initData() {
        ViewFlipper viewFlipper = findViewById(R.id.vf);
        for (int i = 0; i < 4; i++) {
            View view = View.inflate(this, R.layout.item_vf, null);
            TextView text1 = view.findViewById(R.id.item_vf_tv1);
            text1.setText("条目" + i);
            viewFlipper.addView(view);
        }
    }

    @Override
    protected void setEvent() {
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                doSomeThing();
//            }
//        });
    }

    private void doSomeThing() {

    }
}
