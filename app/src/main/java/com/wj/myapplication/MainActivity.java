package com.wj.myapplication;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends BaseActivity {

    private Button button;
    private TextView tv;

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
        tv = findViewById(R.id.tv);
    }

    @Override
    protected void initData() {
        String text = "2020年3月31日";
        Log.i("====",text.length()+"");
        Spannable textSpan = new SpannableStringBuilder(text);
        textSpan.setSpan(new AbsoluteSizeSpan(50), text.indexOf("年"), text.indexOf("年")+1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        textSpan.setSpan(new AbsoluteSizeSpan(50), text.indexOf("月"), text.indexOf("月")+1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        textSpan.setSpan(new AbsoluteSizeSpan(50), text.indexOf("日"), text.indexOf("日")+1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        textSpan.setSpan(new AbsoluteSizeSpan(50), 4, text.indexOf("月"), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        textSpan.setSpan(new AbsoluteSizeSpan(50), text.indexOf("月")-1, text.indexOf("日")-1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        tv.setText(textSpan);
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

    }
}
