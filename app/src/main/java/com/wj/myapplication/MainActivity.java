package com.wj.myapplication;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.zhy.base.fileprovider.FileProvider7;

import java.io.File;

import io.reactivex.functions.Consumer;


public class MainActivity extends BaseActivity {

    private Button button;
    private String str = "https://imtt.dd.qq.com/16891/3CCE99DE9355B0AFDEF59EC03A2C8450.apk?fsname=com.sh.cm.shydhn_2.0.1_7.apk";
    private String pat = Environment.getExternalStorageDirectory().getPath()+ File.separator+"aaa.apk";
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
                File file = new File(pat);
                installApk(file);
            }
        });
    }

    private void doSomeThing() {
        FileDownloader.setup(this);
        FileDownloader.getImpl().create(str)
                .setPath(Environment.getExternalStorageDirectory().getPath()+ File.separator+"aaaaa"+File.separator,true)
                .setListener(new FileDownloadListener() {
                    @Override
                    protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        Log.i("====","pending taskId:"+task.getId()+",fileName:"+task.getFilename()+",soFarBytes:"+soFarBytes+",totalBytes:"+totalBytes+",percent:"+soFarBytes*1.0/totalBytes);
                    }

                    @Override
                    protected void connected(BaseDownloadTask task, String etag, boolean isContinue, int soFarBytes, int totalBytes) {
                        Log.i("====","connected");
                    }

                    @Override
                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        Log.i("====",String.format("%dKB/s", task.getSpeed()));
                    }

                    @Override
                    protected void blockComplete(BaseDownloadTask task) {
                        Log.i("====","blockComplete");
                    }

                    @Override
                    protected void retry(final BaseDownloadTask task, final Throwable ex, final int retryingTimes, final int soFarBytes) {
                        Log.i("====","retry");
                    }

                    @Override
                    protected void completed(BaseDownloadTask task) {
                        Log.i("====","completed");
                        File file = new File(task.getPath()+task.getFilename());
                        installApk(file);
                    }

                    @Override
                    protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        Log.i("====","paused");
                    }

                    @Override
                    protected void error(BaseDownloadTask task, Throwable e) {
                        Log.i("====","error");
                    }

                    @Override
                    protected void warn(BaseDownloadTask task) {
                        Log.i("====","warn");
                    }
                }).start();
    }

    public void installApk(File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        // 仅需改变这一行
        FileProvider7.setIntentDataAndType(this,
                intent, "application/vnd.android.package-archive", file, true);
        startActivity(intent);
    }

    public void installApk1(File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        startActivity(intent);
    }

}
