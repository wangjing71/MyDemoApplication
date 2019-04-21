package com.wj.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.OnKeyboardListener;


public class MainActivity extends BaseActivity {

    private Button button;

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
        ImmersionBar.with(this)
                .keyboardEnable(true)
                .keyboardMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN )
                .setOnKeyboardListener(new OnKeyboardListener() {    //软键盘监听回调
                    @Override
                    public void onKeyboardChange(boolean isPopup, int keyboardHeight) {
                        Log.i("====",isPopup+"___"+keyboardHeight);
                        Toast.makeText(MainActivity.this, isPopup+"___"+keyboardHeight, Toast.LENGTH_SHORT).show();
                    }
                }).init();
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
        Toast.makeText(MainActivity.this,ImmersionBar.hasNavigationBar(this)+"", Toast.LENGTH_SHORT).show();
    }

}
