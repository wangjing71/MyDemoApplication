package com.wj.myapplication;

import android.app.Activity;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import java.io.File;
import java.io.IOException;

/**
 * author wangjing
 * Date 2020/6/15
 * Description
 */
public class VideoActivity extends Activity {
    private SurfaceView videoSurface;       //显示
    private ToggleButton startBtn;          //开始结束按钮
    private MediaRecorder mediarecorder;    // 录制视频的类
    private SurfaceHolder mholder;                  //holder
    private Camera camera;                          //camera

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_video);
        //实例化控件
        videoSurface = (SurfaceView) findViewById(R.id.video_surface);
        startBtn = (ToggleButton) findViewById(R.id.start_btn);
        mholder = videoSurface.getHolder();     // 取得holder
        mholder.setFixedSize(1280, 720);
        mholder.addCallback(surfaceCallback);   // holder加入回调接口
        // setType必须设置，要不出错.设置缓冲类型
        mholder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        startBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    try {
                        mediarecorder.prepare();
                        mediarecorder.start();
                    } catch (Exception e) {
                        Log.e("jiangchen", "onCheckedChanged: " + e.toString());
                    }
                } else {
                    mediarecorder.stop();
                    mediarecorder.release();
                    mediarecorder = null;
                    mholder.removeCallback(surfaceCallback);
                    finish();
                }
            }
        });
    }

    /**
     * SurfaceHolder回调函数。重写SurfaceHolder.Callback接口的surfaceCreated、surfaceChanged、surfaceDestroyed方法。
     */
    SurfaceHolder.Callback surfaceCallback = new SurfaceHolder.Callback() {

        public void surfaceCreated(SurfaceHolder holder) {
            mediarecorder = new MediaRecorder();
            //这设置之后不容易崩
            mediarecorder.setOnErrorListener(null);
            mediarecorder.setOnInfoListener(null);
            mediarecorder.setPreviewDisplay(null);
            camera = Camera.open();                 //打开摄像头
            Log.e("--------", "surfaceCreated");
            try {
//              camera.setDisplayOrientation(90);   //设置camera预览的角度，因为默认图片是倾斜90度的
                camera.setPreviewDisplay(holder);   //设置holder主要是用于surfaceView的图片的实时预览，以及获取图片等功能
                Camera.Parameters parameters = camera.getParameters();
                camera.setParameters(parameters);
                camera.startPreview();                  //开始预览
                camera.unlock();
            } catch (IOException e) {
                camera.release();                   //释放
            }
            mediarecorder.setCamera(camera);
            mediarecorder.reset();
            mediarecorder.setPreviewDisplay(holder.getSurface());
            // 设置录制视频源为Camera(相机)
            mediarecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediarecorder.setVideoSource(MediaRecorder.VideoSource.DEFAULT);
            // 设置录制完成后视频的封装格式THREE_GPP为3gp.MPEG_4为mp4
            mediarecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            // 设置录制的视频编码
            mediarecorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
            mediarecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            // 设置视频录制的分辨率。必须放在设置编码和格式的后面，否则报错,而且这个值要适配
            //手机，不然也会在后面stop方法报错！
            mediarecorder.setVideoSize(1280, 720);
            // 设置录制的视频帧率。必须放在设置编码和格式的后面，否则报错，这样设置变清晰
            mediarecorder.setVideoEncodingBitRate(5 * 1024 * 1024);
            mediarecorder.setOutputFile(Environment.getExternalStorageDirectory().getAbsolutePath() +
                    File.separator + "VisitInsData" + File.separator + "video.mp4");
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                   int height) {

        }

        public void surfaceDestroyed(SurfaceHolder holder) {
            //释放资源
            camera.lock();
            camera.stopPreview();   // stop preview
            camera.release();       // Release camera resources
            camera = null;
            mediarecorder.release();
            mediarecorder = null;
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        if (camera != null) {
            camera.release();
            camera = null;
        }
        if (mediarecorder != null) {
            mediarecorder.release();
            mediarecorder = null;
        }
        if (mholder != null) {
            mholder.removeCallback(surfaceCallback);
        }
    }
}