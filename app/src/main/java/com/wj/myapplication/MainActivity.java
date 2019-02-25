package com.wj.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends BaseActivity {

    private Button button;
    private SMSBroadcastReceiver mSMSBroadcastReceiver;

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
    }

    @Override
    protected void initData() {
        mSMSBroadcastReceiver = new SMSBroadcastReceiver();
        mSMSBroadcastReceiver.setOnReceivedMessageListener(new SMSBroadcastReceiver.MessageListener() {
            public void OnReceived(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
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

    public String getDynamicPwd(String content) {
        // 此正则表达式验证六位数字的短信验证码
        Pattern pattern = Pattern.compile("(?<![0-9])([0-9]{6})(?![0-9])");
        Matcher matcher = pattern.matcher(content);
        String dynamicPwd = "";
        while (matcher.find()) {
            dynamicPwd = matcher.group();
            Log.i("====", "getDynamicPwd: find pwd=" + dynamicPwd);
        }
        return dynamicPwd;
    }
}
