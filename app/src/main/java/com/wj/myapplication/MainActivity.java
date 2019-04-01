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
import com.liulishuo.filedownloader.util.FileDownloadUtils;

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
        String apkUrl = "http://cdn.llsapp.com/android/LLS-v4.0-595-20160908-143200.apk";
        String singleFileSaveName = "liulishuo.apk";
        String mSinglePath = Environment.getExternalStorageState()+ File.separator+"feifei_save"
                +File.separator+singleFileSaveName;
        String mSaveFolder = Environment.getExternalStorageState()+File.separator+"feifei_save";


        FileDownloader.setup(this);
        String str = "http://39.137.36.61:6310/cdn.llsapp.com/android/LLS-v4.0-595-20160908-143200.apk";
        String str1 = "http://117.135.11.27:8049/sh_rest/httpservice/filedownload";
        FileDownloader.getImpl().create(str)
                .setPath(mSinglePath,true)
                .setListener(new FileDownloadListener() {
                    @Override
                    protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        Log.i("====","pending");
                    }

                    @Override
                    protected void connected(BaseDownloadTask task, String etag, boolean isContinue, int soFarBytes, int totalBytes) {
                        Log.i("====","connected");
                    }

                    @Override
                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        Log.i("====","progress");
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
}
