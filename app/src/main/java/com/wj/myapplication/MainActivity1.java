package com.wj.myapplication;

import android.Manifest;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.SurfaceHolder.Callback;

import com.tbruyelle.rxpermissions2.Permission;

import io.reactivex.functions.Consumer;


public class MainActivity1 extends BaseActivity {

    private Button button;
    private Camera mCamera;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
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
        rxPermissions.requestEachCombined(Manifest.permission.CAMERA
                , Manifest.permission.WRITE_EXTERNAL_STORAGE
                , Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {//全部同意后调用
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            Toast.makeText(MainActivity1.this, "拒绝了权限申请", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity1.this, "拒绝了权限申请", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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

}
