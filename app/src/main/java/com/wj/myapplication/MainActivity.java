package com.wj.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;
import java.io.IOException;

import io.reactivex.functions.Consumer;


public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button luzhi;
    private Camera camera;
    private CameraView cameraView;
    private static final int FRONT = 1;//前置摄像头标记
    private static final int BACK = 2;//后置摄像头标记
    private int currentCameraType = -1;//当前打开的摄像头标记

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RxPermissions rxPermissions = new RxPermissions(MainActivity.this);
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) {
                    }
                });

        if (!checkCamera()) {
            MainActivity.this.finish();
        }
        try {
            camera = openCamera(FRONT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        button = findViewById(R.id.button);
        luzhi = findViewById(R.id.luzhi);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    changeCamera();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        cameraView = (CameraView) findViewById(R.id.cameraview);
        cameraView.init(camera);

        luzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRecord();
            }
        });

        findViewById(R.id.end).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private MediaRecorder mRecorder;    // 录制视频的类
    //开始录制
    private void startRecord() {
        mRecorder = new MediaRecorder();
        mRecorder.reset();
        mRecorder.setCamera(camera);
        // 这两项需要放在setOutputFormat之前
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setVideoSource(MediaRecorder.VideoSource.DEFAULT);
        // Set output file format
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        // 这两项需要放在setOutputFormat之后
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);

        mRecorder.setVideoSize(1280, 720);
        mRecorder.setVideoFrameRate(30);
        mRecorder.setVideoEncodingBitRate(5 * 1024 * 1024);
        mRecorder.setOrientationHint(270);
        //设置记录会话的最大持续时间（毫秒）
        mRecorder.setMaxDuration(30 * 1000);
        mRecorder.setOutputFile(Environment.getExternalStorageDirectory().getAbsolutePath() +
                File.separator + "video.mp4");
        try {
            mRecorder.prepare();
            mRecorder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //结束录制
    private void stopRecord() {
        mRecorder.stop();
        mRecorder.reset();
        mRecorder.release();
        mRecorder = null;
        camera.stopPreview();
        camera.release();
        camera = null;
    }

    /**
     * @return 摄像头是否存在
     */
    private boolean checkCamera() {
        return MainActivity.this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    @SuppressLint("NewApi")
    private Camera openCamera(int type) {
        int frontIndex = -1;
        int backIndex = -1;
        int cameraCount = Camera.getNumberOfCameras();
        Camera.CameraInfo info = new Camera.CameraInfo();
        for (int cameraIndex = 0; cameraIndex < cameraCount; cameraIndex++) {
            Camera.getCameraInfo(cameraIndex, info);
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                frontIndex = cameraIndex;
            } else if (info.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                backIndex = cameraIndex;
            }
        }

        currentCameraType = type;
        if (type == FRONT && frontIndex != -1) {
            return Camera.open(frontIndex);
        } else if (type == BACK && backIndex != -1) {
            return Camera.open(backIndex);
        }
        return null;
    }

    private void changeCamera() throws IOException {
        camera.stopPreview();
        camera.release();
        if (currentCameraType == FRONT) {
            camera = openCamera(BACK);
        } else if (currentCameraType == BACK) {
            camera = openCamera(FRONT);
        }
        camera.setPreviewDisplay(cameraView.getHolder());
        camera.startPreview();
    }


}
