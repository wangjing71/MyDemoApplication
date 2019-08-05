package com.wj.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

/**
 * author wangjing
 * Date 2019/7/29
 * Description
 */
public class SplashActivity extends FragmentActivity {
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Intent intent = new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.ap2, R.anim.ap1);
        }
    };

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
        handler.sendEmptyMessageDelayed(0,3000);
    }

    private void setEvent() {

    }
}
