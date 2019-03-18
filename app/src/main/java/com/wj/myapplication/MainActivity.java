package com.wj.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.wj.jcvideo.JCVideoPlayerStandard;


public class MainActivity extends BaseActivity {

    private JCVideoPlayerStandard jcVideoPlayerStandard;
    private View bacView;

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
        bacView = findViewById(R.id.bac);
    }

    @Override
    protected void initData() {
        jcVideoPlayerStandard.setUp("http://192.168.3.100:8080/aaa.mp4", JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "测试视频");
        jcVideoPlayerStandard.startPlayLogic();
    }

    @Override
    protected void setEvent() {
        jcVideoPlayerStandard.setOnPlayListener(new JCVideoPlayerStandard.onPlayListener() {
            @Override
            public void startPre() {
                Log.i("====","startPre");
            }

            @Override
            public void startPly() {
                Log.i("====","startPly");
                bacView.setVisibility(View.GONE);
            }

            @Override
            public void playComplete() {
                Log.i("====","playComplete");
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        jcVideoPlayerStandard.releaseAllVideos();
    }

}
