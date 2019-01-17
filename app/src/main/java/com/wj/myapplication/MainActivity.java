package com.wj.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends BaseActivity {

    private Button button;
    private Button button2;
    private EditText editText;

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
        button2= findViewById(R.id.button2);
        editText = findViewById(R.id.edittext);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoftKeyboardUtil.hideSoft(MainActivity.this,editText);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoftKeyboardUtil.showSoft(MainActivity.this,editText);
            }
        });
    }

    private void doSomeThing() {

    }
}
