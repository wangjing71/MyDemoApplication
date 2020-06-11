package com.wj.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wj.myapplication.safe.CheckUtils;
import com.wj.myapplication.safe.EmulatorCheckCallback;
import com.wj.myapplication.safe.EmulatorCheckUtil;
import com.wj.myapplication.safe.RootUtils;
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
}
