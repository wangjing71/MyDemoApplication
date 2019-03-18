package com.wj.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.wj.jcvideo.JCVideoPlayerStandard;


public class MainActivity extends BaseActivity {

    private JCVideoPlayerStandard jcVideoPlayerStandard;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int st = jcVideoPlayerStandard.getCurrentPositionWhenPlaying();
            if(st>0){
                Toast.makeText(MainActivity.this, "开始播放", Toast.LENGTH_SHORT).show();
            }else{
                handler.sendEmptyMessageDelayed(0,200);
            }

        }
    };

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
        handler.sendEmptyMessage(0);
        jcVideoPlayerStandard.setUp("http://192.168.3.100:8080/aaa.mp4", JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "测试视频");
        jcVideoPlayerStandard.startPlayLogic();
    }

    @Override
    protected void setEvent() {
    }
}
