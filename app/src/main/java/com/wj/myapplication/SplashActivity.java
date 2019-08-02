package com.wj.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;

/**
 * author wangjing
 * Date 2019/7/29
 * Description
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        ImmersionBar.with(this).init();
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
