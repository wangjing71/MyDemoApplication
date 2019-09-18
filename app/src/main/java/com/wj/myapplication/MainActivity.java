package com.wj.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;


public class MainActivity extends BaseActivity {

    private Button button;
    private TextView textView;

    private Badge bar;

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
        textView = findViewById(R.id.textView);
    }

    @Override
    protected void initData() {
        bar = new QBadgeView(this).bindTarget(button);
        bar.setBadgeNumber(5);
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
        bar.hide(true);
        new QBadgeView(this).bindTarget(textView).setBadgeNumber(5).setBadgeBackgroundColor(Color.RED).setBadgeTextSize(8.0f,true);
    }
}
