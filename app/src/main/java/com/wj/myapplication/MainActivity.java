package com.wj.myapplication;

import android.Manifest;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.wj.jcvideo.JCMediaManager;
import com.wj.jcvideo.JCUtils;
import com.wj.jcvideo.JCVideoPlayerStandard;

import io.reactivex.functions.Consumer;


public class MainActivity extends BaseActivity {

    private JCVideoPlayerStandard jcVideoPlayerStandard;
    private View bacView;
    private Button btn,btn1;

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
        btn = findViewById(R.id.btn);
        btn1 = findViewById(R.id.btn1);
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request( Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) {

                    }
                });
    }

    @Override
    protected void initData() {
        String videoUrl = SDCardUtils.getSDPath()+"aaa.mp4";
        JCUtils.clearSavedProgress(this,videoUrl);
        jcVideoPlayerStandard.setUp(videoUrl, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "测试视频");
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

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JCMediaManager.instance().mediaPlayer.pause();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JCMediaManager.instance().mediaPlayer.start();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        jcVideoPlayerStandard.releaseAllVideos();
    }
}
