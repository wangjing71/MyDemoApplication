package com.wj.myapplication;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.Permission;

import java.io.File;

import io.reactivex.functions.Consumer;

import static android.media.MediaMetadataRetriever.OPTION_CLOSEST_SYNC;


public class MainActivity extends BaseActivity {

    private Button button;
    private ImageView show;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        button = findViewById(R.id.button);
        show = findViewById(R.id.show);
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

        findViewById(R.id.get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaMetadataRetriever mmr = new MediaMetadataRetriever();
                String path= Environment.getExternalStorageDirectory().getAbsolutePath() +
                        File.separator + "video.mp4";
                mmr.setDataSource(path);
                Bitmap bitmap = mmr.getFrameAtTime(1*1000*1000,OPTION_CLOSEST_SYNC );//获取1秒附近的关键帧
                show.setImageBitmap(bitmap);
            }
        });
    }

    private void doSomeThing() {
        rxPermissions.requestEachCombined(Manifest.permission.CAMERA
                ,Manifest.permission.RECORD_AUDIO
                , Manifest.permission.WRITE_EXTERNAL_STORAGE
                , Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {//全部同意后调用
                            Intent intent = new Intent(MainActivity.this,A.class);
                            startActivity(intent);
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            Toast.makeText(MainActivity.this, "拒绝了权限申请", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "拒绝了权限申请", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
