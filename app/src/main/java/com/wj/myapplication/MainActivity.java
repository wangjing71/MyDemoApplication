package com.wj.myapplication;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;

import io.reactivex.functions.Consumer;
import okhttp3.Call;


public class MainActivity extends BaseActivity {
    private String FILE_URL = "http://117.135.11.27:8049/sh_rest/httpservice/filedownload";

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
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rxPermissions.requestEach(Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .subscribe(new Consumer<Permission>() {
                            @Override
                            public void accept(Permission permission) throws Exception {
                                if (permission.name.equalsIgnoreCase(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                                    if (permission.granted) {//同意后调用
                                        doSomeThing();
                                    } else if (permission.shouldShowRequestPermissionRationale) {//禁止，但没有选择“以后不再询问”，以后申请权限，会继续弹出提示
                                    } else {//禁止，但选择“以后不再询问”，以后申请权限，不会继续弹出提示
                                    }
                                }
                            }
                        });
                doSomeThing();
            }
        });
    }

    private void doSomeThing() {
        OkHttpUtils
                .get()
                .url(FILE_URL)//
                .build()//
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(),"111.apk")//
                {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(MainActivity.this, "下载失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(File response, int id) {
                        Toast.makeText(MainActivity.this, "下载成功", Toast.LENGTH_SHORT).show();
                    }

                });
    }
}
