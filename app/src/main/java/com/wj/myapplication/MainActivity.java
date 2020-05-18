package com.wj.myapplication;


import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.wj.myapplication.vp.MyTextRollView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private MyTextRollView myTextRollView;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        myTextRollView  = findViewById(R.id.myrollview);
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("条目"+i);
        }
        myTextRollView.setDataStrList(data);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void setEvent() {
        myTextRollView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("====","myTextRollView");
            }
        });

        myTextRollView.setTvItemClick(new MyTextRollView.TvItemClick() {
            @Override
            public void itemClick(int position) {
                Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
