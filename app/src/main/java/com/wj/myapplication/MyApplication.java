package com.wj.myapplication;

import android.app.Application;

import com.tencent.bugly.Bugly;
import com.xuexiang.xui.XUI;

/**
 * author wangjing
 * Date 2018/11/29
 * Description
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bugly.init(getApplicationContext(), "9c59c60539", false);

        XUI.init(this); //初始化UI框架
        XUI.debug(true);  //开启UI框架调试日志
    }
}
