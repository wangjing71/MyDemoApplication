package com.wj.myapplication;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;

import java.io.File;

import io.reactivex.functions.Consumer;


public class MainActivity extends BaseActivity {

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
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) {
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
        FileDownloader.setup(this);
        String str = "http://cdn.llsapp.com/android/LLS-v4.0-595-20160908-143200.apk";
        String str1 = "http://117.135.11.27:8049/sh_rest/httpservice/filedownload";
        FileDownloader.getImpl().create(str)
                .setPath(Environment.getExternalStorageDirectory().getPath()+ File.separator+"11.apk")
                .setListener(new SimpleFileDownloadListener(){
                    @Override
                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        super.progress(task, soFarBytes, totalBytes);
                        Log.i("====",task.getSpeed()+"");
                    }
                }).start();
    }
}
