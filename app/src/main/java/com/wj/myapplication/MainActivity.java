package com.wj.myapplication;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;
import java.io.FileInputStream;

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
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) {
                        if (aBoolean) {
                            getFileBase64(Environment.getExternalStorageDirectory().getAbsolutePath() +
                                    File.separator+"a.jpg");
                        } else {
                            Toast.makeText(MainActivity.this, "-1", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private String getFileBase64(final String filepath) {
        ThreadPoolUtil.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    File file = new File(filepath);
                    FileInputStream inputFile = new FileInputStream(file);
                    byte[] buffer = new byte[(int) file.length()];
                    inputFile.read(buffer);
                    inputFile.close();
                    String result = Base64.encodeToString(buffer, Base64.DEFAULT);
                    doTosat(result);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "-1", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return "";
    }

    private void doTosat(final String result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ImageView show = findViewById(R.id.show);
                show.setImageBitmap(Base64BitmapUtil.base64ToBitmap(result));
            }
        });
    }
}
