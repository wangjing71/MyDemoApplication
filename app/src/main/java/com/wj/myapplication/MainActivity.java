package com.wj.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wj.myapplication.safe.EmulatorCheckCallback;
import com.wj.myapplication.safe.EmulatorCheckUtil;
import com.wj.myapplication.safe.VirtualApkCheckUtil;
import com.wj.myapplication.safe.VirtualCheckCallback;


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
        doSomeThing();

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
        if(CheckUtils.isRoot()){
            Toast.makeText(this, "设备存在root风险", Toast.LENGTH_SHORT).show();
        }
        VirtualApkCheckUtil.getSingleInstance().checkByCreateLocalServerSocket(getPackageName(), new VirtualCheckCallback() {
            @Override
            public void findSuspect() {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setTitle("温馨提示").setMessage("检测到您正在进行双开操作，请退出。").setNegativeButton("退出", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setCancelable(false).show();
            }

            @Override
            public void next() {
                //检查版本更新
            }
        });

        EmulatorCheckUtil.getSingleInstance().readSysProperty(this, new EmulatorCheckCallback() {
            @Override
            public void findEmulator(String emulatorInfo) {
                Toast.makeText(MainActivity.this, "是模拟器", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
