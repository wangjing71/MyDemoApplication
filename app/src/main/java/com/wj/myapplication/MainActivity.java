package com.wj.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends BaseActivity {

    private Button button;
    private FloatView floatView;
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
        floatView = new FloatView(this, 0, 0, R.layout.floatview_layotu);
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
        floatView.setFloatViewClickListener(new FloatView.IFloatViewClick() {
            @Override
            public void onFloatViewClick() {
                Toast.makeText(MainActivity.this, "floatview is clicked", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onStart() {
        floatView.addToWindow();
        super.onStart();
    }

    @Override
    protected void onStop() {
        floatView.removeFromWindow();
        super.onStop();
    }
}
