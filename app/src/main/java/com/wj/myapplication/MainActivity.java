package com.wj.myapplication;

import android.net.Uri;
import android.os.Bundle;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.utils.Log;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;


public class MainActivity extends BaseActivity implements MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener {

    private String path = "http://192.168.3.100:8080/aaa.mp4";
    private VideoView mVideoView;
    private MyMediaController myMediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(getApplicationContext());
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mVideoView = (VideoView) findViewById(R.id.buffer);
        Uri uri = Uri.parse(path);
        mVideoView.setVideoURI(uri);
        //创建控制器
        myMediaController = new MyMediaController(this, mVideoView);
        //设置控制器
//        mVideoView.setMediaController(myMediaController);
        mVideoView.setMediaController(new MediaController(this) {
        });
        mVideoView.requestFocus();
        mVideoView.setOnInfoListener(this);
        mVideoView.setBufferSize(10240); //设置视频缓冲大小
        mVideoView.setOnBufferingUpdateListener(this);
        mVideoView.setOnTimedTextListener(new MediaPlayer.OnTimedTextListener() {
            @Override
            public void onTimedText(String text) {
                Log.i("onTimedText",text);
            }

            @Override
            public void onTimedTextUpdate(byte[] pixels, int width, int height) {
            }
        });
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
    }

    private void doSomeThing() {

    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {

    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        switch (what) {
            //开始缓冲
            case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                if (mVideoView.isPlaying()) {
                    mVideoView.pause();
                }
                break;
            case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                //缓冲结束
                mVideoView.start();
                break;
            //正在缓冲
            case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                break;
        }
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
