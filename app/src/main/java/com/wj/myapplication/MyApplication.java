package com.wj.myapplication;

import android.app.Application;
import android.widget.Toast;

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
        Bugly.init(getApplicationContext(), "9c59c60539", false);
        initBackFrontGround();
    }

    private void initBackFrontGround() {
        AppFrontBackHelper helper = new AppFrontBackHelper();
        helper.register(MyApplication.this, new AppFrontBackHelper.OnAppStatusListener() {
            @Override
            public void onFront() {
                //应用切到前台处理
//                Toast.makeText(RichenInfoApplication.this, "前台", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBack() {
                //应用切到后台处理
                Toast.makeText(MyApplication.this, "上海移动和你已切换到后台运行", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
