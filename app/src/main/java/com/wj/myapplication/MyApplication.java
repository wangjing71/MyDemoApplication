package com.wj.myapplication;

import android.app.Application;

import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.connection.FileDownloadUrlConnection;
import com.lzy.okgo.OkGo;
import com.tencent.bugly.Bugly;

/**
 * author wangjing
 * Date 2018/11/29
 * Description
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        Bugly.init(getApplicationContext(), "9c59c60539", false);
        OkGo.getInstance().init(this);
    }
}
