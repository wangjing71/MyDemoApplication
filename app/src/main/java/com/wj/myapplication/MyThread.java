package com.wj.myapplication;

import android.app.Activity;

/**
 * author wangjing
 * Date 2020/3/10
 * Description
 */
public class MyThread extends Thread {
    private Activity activity;

    public MyThread(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void run() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
