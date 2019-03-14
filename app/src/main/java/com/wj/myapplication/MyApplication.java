package com.wj.myapplication;

import android.app.Application;

import com.shuyu.gsyvideoplayer.player.PlayerFactory;
import com.tencent.bugly.Bugly;

import tv.danmaku.ijk.media.exo2.Exo2PlayerManager;

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
        PlayerFactory.setPlayManager(Exo2PlayerManager.class);//EXO模式
    }
}
