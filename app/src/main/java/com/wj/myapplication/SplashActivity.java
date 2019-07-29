package com.wj.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

/**
 * author wangjing
 * Date 2019/7/29
 * Description
 */
public class SplashActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        initData();
        setEvent();
    }

    private void initView() {

    }

    private void initData() {
        Toast.makeText(this, "1111111111111", Toast.LENGTH_SHORT).show();

    }

    private void setEvent() {

    }
}
