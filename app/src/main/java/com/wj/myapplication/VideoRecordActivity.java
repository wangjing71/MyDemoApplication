package com.wj.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.File;
import java.util.Calendar;


/**
 * author wangjing
 * Date 2020/6/23
 * Description
 */
public class VideoRecordActivity extends AppCompatActivity {
    private boolean mStartedFlag = false; //录像中标志
    private MediaRecorder mRecorder;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceView surfaceView;
    private Camera mCamera;
    private MediaPlayer mMediaPlayer;
    private String path;
    private int timer = 0; //计时器
    private int maxSec = 10;
    private String imgPath;

    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            timer++;
            if (timer < maxSec) {
                handler.postDelayed(this, 1000);
            } else {
                //停止录制 保存录制的流、显示供操作的ui
                stopRecord();
                System.currentTimeMillis();
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_record);
        surfaceView = findViewById(R.id.mSurfaceview);
        mMediaPlayer = new MediaPlayer();
        SurfaceHolder holder = surfaceView.getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    mSurfaceHolder = holder;
                    //使用后置摄像头
                    mCamera = Camera.open(Camera.CameraInfo.CAMERA_FACING_BACK);
                    //选装90度
                    mCamera.setDisplayOrientation(90);
                    mCamera.setPreviewDisplay(holder);
                    Camera.Parameters parameters = mCamera.getParameters();
                    parameters.setPictureFormat(PixelFormat.JPEG);
                    parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
                    mCamera.setParameters(parameters);
                } catch (Exception e) {
                    //开启摄像头失败
                    finish();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                mSurfaceHolder = holder;
                mCamera.startPreview();
                mCamera.cancelAutoFocus();
                mCamera.unlock();
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                handler.removeCallbacks(runnable);
            }
        });

        findViewById(R.id.mBtnRecord).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    stopRecord();
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    startRecord();
                }
                return false;
            }
        });

        findViewById(R.id.mBtnPlay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playRecord();
            }
        });
        findViewById(R.id.mBtnCancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlay();
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

        findViewById(R.id.mBtnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlay();
                Intent intent = new Intent();
                intent.putExtra("path", path);
                intent.putExtra("imagePath", imgPath);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mRecorder.release();
        mRecorder = null;
        mCamera.stopPreview();
        mCamera.release();
        mCamera = null;
        mMediaPlayer.release();
        mMediaPlayer = null;
    }


    //开始录制
    private void startRecord() {
        if (!mStartedFlag) {
            mStartedFlag = true;
//            findViewById(R.id.)
            findViewById(R.id.mLlRecordOp).setVisibility(View.INVISIBLE);
            findViewById(R.id.mBtnPlay).setVisibility(View.INVISIBLE);
            findViewById(R.id.mLlRecordBtn).setVisibility(View.INVISIBLE);
            //开始计时
            handler.postDelayed(runnable, 1000);
            mRecorder = new MediaRecorder();
            mRecorder.reset();
            mRecorder.setCamera(mCamera);
            // 这两项需要放在setOutputFormat之前
            mRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
            mRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
            // Set output file format
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            // 这两项需要放在setOutputFormat之后
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);

            mRecorder.setVideoSize(640, 480);
            mRecorder.setVideoFrameRate(30);
            mRecorder.setVideoEncodingBitRate(3 * 1024 * 1024);
            mRecorder.setOrientationHint(90);
            //设置记录会话的最大持续时间（毫秒）
            mRecorder.setMaxDuration(30 * 1000);
            path = Environment.getExternalStorageDirectory().getPath() + File.separator + "Video";
            if (path != null) {
                File dir = new File(path);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                path = dir.getAbsolutePath() + "/" + getDate() + ".mp4";
                mRecorder.setOutputFile(path);
                try {
                    mRecorder.prepare();
                    mRecorder.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //结束录制
    private void stopRecord() {
        if (mStartedFlag) {
            mStartedFlag = false;
            findViewById(R.id.mLlRecordOp).setVisibility(View.VISIBLE);
            findViewById(R.id.mBtnPlay).setVisibility(View.VISIBLE);
            findViewById(R.id.mLlRecordBtn).setVisibility(View.INVISIBLE);

            handler.removeCallbacks(runnable);
            mRecorder.stop();
            mRecorder.reset();
            mRecorder.release();
            mRecorder = null;
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
            MediaUtils.getImageForVideo(path, new MediaUtils.OnLoadVideoImageListener() {
                @Override
                public void onLoadImage(File file) {
                    imgPath = file.getAbsolutePath();
                }
            });
        }
    }

    //播放录像
    private void playRecord() {
        findViewById(R.id.mBtnPlay).setVisibility(View.INVISIBLE);
        mMediaPlayer.reset();
        Uri uri = Uri.parse(path);
        mMediaPlayer = MediaPlayer.create(this, uri);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setDisplay(mSurfaceHolder);
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                findViewById(R.id.mBtnPlay).setVisibility(View.VISIBLE);
            }
        });
        try {
            mMediaPlayer.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mMediaPlayer.start();
    }

    //停止播放录像
    private void stopPlay() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
        }
    }

    /**
     * 获取系统时间
     *
     * @return
     */
    private String getDate() {
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        ;     // 获取年份
        int month = ca.get(Calendar.MONTH);        // 获取月份
        int day = ca.get(Calendar.DATE);       // 获取日
        int minute = ca.get(Calendar.MINUTE);    // 分
        int hour = ca.get(Calendar.HOUR);      // 小时
        int second = ca.get(Calendar.SECOND);     // 秒
        return "" + year + (month + 1) + day + hour + minute + second;
    }
}
