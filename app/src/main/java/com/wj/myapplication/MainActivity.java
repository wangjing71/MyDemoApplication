package com.wj.myapplication;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.reactivex.functions.Consumer;


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
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.requestEach(Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.name.equalsIgnoreCase(Manifest.permission.ACCESS_FINE_LOCATION)) {
                            if (permission.granted) {//同意后调用
                            } else if (permission.shouldShowRequestPermissionRationale) {//禁止，但没有选择“以后不再询问”，以后申请权限，会继续弹出提示
                            } else {//禁止，但选择“以后不再询问”，以后申请权限，不会继续弹出提示
                            }
                        }
                    }
                });
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
