package com.wj.myapplication;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.Permission;

import io.reactivex.functions.Consumer;


public class MainActivity extends BaseActivity {

    private Button button;

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
        rxPermissions.requestEachCombined(Manifest.permission.CAMERA)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {//全部同意后调用
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            Toast.makeText(MainActivity.this, "拒绝了权限申请", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "拒绝了权限申请", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
