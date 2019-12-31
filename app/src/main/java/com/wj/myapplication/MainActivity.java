package com.wj.myapplication;

import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.model.PluginInfo;
import com.tbruyelle.rxpermissions2.RxPermissions;

import android.Manifest;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) {

                    }
                });
        /**
         * 简单测试activity
         */
        findViewById(R.id.btn_plugin1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = RePlugin.createIntent("process_map", "com.wj.mychajian.MainActivity");
                intent.putExtra("data","wangjing");
                RePlugin.startActivity(MainActivity.this, intent);
            }
        });


        /**
         * 测试插件升级
         */
        findViewById(R.id.id_btn_test_update_plugins).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(Environment
                        .getExternalStorageDirectory() + File.separator + "plu.apk");
                if (file.exists()) {
                    PluginInfo info = RePlugin.install(file.getAbsolutePath());
                    Log.i(TAG, "installPluginInfo: " + info.toString());
                } else {
                    Toast.makeText(MainActivity.this, "文件不存在", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
