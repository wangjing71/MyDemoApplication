package com.wj.myapplication;

import android.app.Application;

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
        Bugly.init(getApplicationContext(), "056ce00d43", false);
    }
}
