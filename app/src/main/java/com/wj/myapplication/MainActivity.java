package com.wj.myapplication;

import android.os.Bundle;
import android.util.Log;

import com.wj.jcvideo.JCUserAction;
import com.wj.jcvideo.JCUserActionStandard;
import com.wj.jcvideo.JCVideoPlayerStandard;


public class MainActivity extends BaseActivity {

    private JCVideoPlayerStandard jcVideoPlayerStandard;

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
        jcVideoPlayerStandard = findViewById(R.id.videoplayer);
    }

    @Override
    protected void initData() {
        jcVideoPlayerStandard.setUp("http://192.168.3.100:8080/aaa.mp4", JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "测试视频");
        jcVideoPlayerStandard.startPlayLogic();
    }

    @Override
    protected void setEvent() {
    }

    @Override
    protected void onPause() {
        super.onPause();
        jcVideoPlayerStandard.releaseAllVideos();
    }

}
