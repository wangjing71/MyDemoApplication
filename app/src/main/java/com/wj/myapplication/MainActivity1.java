package com.wj.myapplication;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.SurfaceHolder.Callback;

import java.io.File;


public class MainActivity1 extends BaseActivity {

    private Button button;
    private Camera mCamera;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private File mVecordFile;
    private MediaRecorder mediaRecorder;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main1;
    }

    @Override
    protected void initView() {
        button = findViewById(R.id.button);
        surfaceView = findViewById(R.id.surfaceView1);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(surfaceHolderCallback); // holder加入回调接口
        // setType必须设置，要不出错.
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    @Override
    protected void initData() {
        initCamera();
        boolean creakOk = createRecordDir();
        if (!creakOk) {
            return;
        }

        try {
            mCamera.unlock();
            setConfigRecord();

            mediaRecorder.prepare();
            mediaRecorder.start();
        } catch (Exception e) {
            //Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void setEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSomeThing();
            }
        });
    }

    private void doSomeThing() {
        boolean creakOk = createRecordDir();
        if (!creakOk) {
            return;
        }

        try {
            mCamera.unlock();
            setConfigRecord();

            mediaRecorder.prepare();
            mediaRecorder.start();
        } catch (Exception e) {
            //Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void initCamera() {
        mCamera = Camera.open(0);  //①
        mCamera.setDisplayOrientation(90);
        try {
            mCamera.setPreviewDisplay(surfaceHolder);

            mCamera.cancelAutoFocus();//此句加上 可自动聚焦 必须加
            Camera.Parameters parameters = mCamera.getParameters();
            //查询摄像头支持的分辨率
            parameters.getSupportedPreviewSizes();
            for (int i = 0; i < parameters.getSupportedPreviewSizes().size(); i++) {
                Log.i("<><><><>Width", parameters.getSupportedPreviewSizes().get(i).width + "");
                Log.i("<><><><>Height", parameters.getSupportedPreviewSizes().get(i).height + "");
            }
            //设置分辨率
            parameters.setPreviewSize(1280, 720);
            //设置聚焦模式
            parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);
            //缩短Recording启动时间
            parameters.setRecordingHint(true);
            //是否支持影像稳定能力，支持则开启
            if (parameters.isVideoStabilizationSupported())
                parameters.setVideoStabilization(true);
            mCamera.setParameters(parameters);
            mCamera.startPreview();
        } catch (Exception e) {
            Log.i("TAG", "Error starting camera preview: " + e.getMessage());
        }
    }

    Callback surfaceHolderCallback = new Callback() {

        @Override
        public void surfaceDestroyed(SurfaceHolder arg0) {
            surfaceView = null;
            surfaceHolder = null;
//            mRecorder = null;
        }

        @Override
        public void surfaceCreated(SurfaceHolder arg0) {
            // TODO Auto-generated method stub
            surfaceHolder = arg0;
        }

        @Override
        public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2,
                                   int arg3) {
            // TODO Auto-generated method stub
            surfaceHolder = arg0;
        }
    };

    private boolean createRecordDir() {
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            Toast.makeText(this, "SD卡不存在!", Toast.LENGTH_SHORT).show();
            return false;
        }

        File sampleDir = new File("/sdcard/myVideo/");
        if (!sampleDir.exists()) {
            sampleDir.mkdirs();
        }
        String videoName = "VID_" + System.currentTimeMillis() + ".mp4";
        mVecordFile = new File(sampleDir, videoName);

        return true;
    }

    private void setConfigRecord() {
        mediaRecorder = new MediaRecorder();
        mediaRecorder.reset();
        mediaRecorder.setCamera(mCamera);
        mediaRecorder.setOnErrorListener(new MediaRecorder.OnErrorListener() {
            @Override
            public void onError(MediaRecorder mr, int what, int extra) {

            }
        });
        //录像角度
        mediaRecorder.setOrientationHint(90);
        //使用SurfaceView预览
        mediaRecorder.setPreviewDisplay(surfaceHolder.getSurface());
        //1.设置采集声音
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        //设置采集图像
        mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
        //2.设置视频，音频的输出格式 mp4
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        //3.设置音频的编码格式
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
        //设置图像的编码格式
        mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);
        CamcorderProfile mProfile = CamcorderProfile.get(CamcorderProfile.QUALITY_480P);

        mediaRecorder.setAudioEncodingBitRate(44100);
        if (mProfile.videoBitRate > 2 * 1024 * 1024) {
            mediaRecorder.setVideoEncodingBitRate(2 * 1024 * 1024);
        } else {
            mediaRecorder.setVideoEncodingBitRate(1024 * 1024);
        }
        mediaRecorder.setVideoFrameRate(mProfile.videoFrameRate);
        mediaRecorder.setVideoSize(1280, 720);

        mediaRecorder.setOutputFile(mVecordFile.getAbsolutePath());
    }


}
