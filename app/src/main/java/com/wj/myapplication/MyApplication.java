package com.wj.myapplication;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tencent.bugly.Bugly;

/**
 * author wangjing
 * Date 2018/11/29
 * Description
 */
public class MyApplication extends Application {

    public BaseActivity currentActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        Bugly.init(getApplicationContext(), "9c59c60539", false);
        initBackFrontGround();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.d("====", activity + "onActivityCreated");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.d("====", activity + "onActivityStarted");
                currentActivity = (BaseActivity) activity;
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.d("====", activity + "onActivityResumed");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.d("====", activity + "onActivityPaused");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.d("====", activity + "onActivityStopped");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Log.d("====", activity + "onActivitySaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.d("====", activity + "onActivityDestroyed");
            }
        });


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
                currentActivity.showMohu();
                Toast.makeText(MyApplication.this, "上海移动和你已切换到后台运行", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
