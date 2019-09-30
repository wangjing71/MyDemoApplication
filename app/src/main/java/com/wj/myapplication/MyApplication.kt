package com.wj.myapplication

import android.app.Application

import com.tencent.bugly.Bugly

/**
 * author wangjing
 * Date 2018/11/29
 * Description
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Bugly.init(applicationContext, "9c59c60539", false)
    }
}
