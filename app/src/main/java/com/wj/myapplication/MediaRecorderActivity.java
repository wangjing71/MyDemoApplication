package com.wj.myapplication;

import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.io.IOException;

/**
 * author wangjing
 * Date 2020/6/15
 * Description
 */
public class MediaRecorderActivity extends AppCompatActivity {

    private SurfaceView sv_mediarecorder_surface;
    private MediaRecorder mediaRecorder;
    private boolean isStartAndStop=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_mediarecorder);
        //获取SurfaceView
        sv_mediarecorder_surface = (SurfaceView) findViewById(R.id.sv_mediarecorder_surface);
        //实例化媒体录制器
        mediaRecorder = new MediaRecorder();
        startMediaCorder(findViewById(R.id.start));

    }

    //视频录制与暂停的方法
    public void startMediaCorder(View view){
        Button button= (Button) view;
        if (!isStartAndStop) {
            if (mediaRecorder==null){
                //实例化媒体录制器
                mediaRecorder = new MediaRecorder();
            }
            mediaRecorder.reset();
            mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA); //从照相机采集视频
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);//设置麦克风
            //设置保存的格式
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            //设置编码格式
            mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H263);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.setVideoFrameRate(3);
            //获取根路径
            String sdPath= Environment.getExternalStorageDirectory().getAbsolutePath();
            //设置保存的路径
            mediaRecorder.setOutputFile(sdPath+"/taoge"+System.currentTimeMillis()+".mp4");
            //将画面展示到SurfaceView
            mediaRecorder.setPreviewDisplay(sv_mediarecorder_surface.getHolder().getSurface());
            //准备
            try {
                mediaRecorder.prepare();
                mediaRecorder.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
            button.setText("结束");
        }else{

            // 为其它应用释放摄像头
            mediaRecorder.release();
            mediaRecorder = null;
            //关闭
            button.setText("开始");
        }
        isStartAndStop=!isStartAndStop;
    }


}
