package com.wj.myapplication;

import android.app.Application;

import com.qihoo360.replugin.RePluginApplication;
import com.tencent.bugly.Bugly;

/**
 * author wangjing
 * Date 2018/11/29
 * Description
 */
public class MyApplication extends RePluginApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Bugly.init(getApplicationContext(), "9c59c60539", false);
    }
}
