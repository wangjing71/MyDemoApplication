package com.wj.myapplication;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tbruyelle.rxpermissions2.Permission;

import io.reactivex.functions.Consumer;


public class MainActivity extends BaseActivity {

    private View barView;
    private Button button1,button2,button3,button4;
    private String FILE_URL = "https://imtt.dd.qq.com/16891/3CCE99DE9355B0AFDEF59EC03A2C8450.apk?fsname=com.sh.cm.shydhn_2.0.1_7.apk";

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
        barView = findViewById(R.id.barView);
        ImmersionBar.setStatusBarView(this,barView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doGet();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPost();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doDownload();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dostParms();
            }
        });
    }

    private void dostParms() {
        OkGo.<String>post("http://www.baidu.com")
                .tag(this)
                .upJson("") //这里传JSON参数
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Toast.makeText(MainActivity.this, response.body(), Toast.LENGTH_SHORT).show();
                        Log.i("====",response.body());

                    }
                });
    }

    private void doDownload() {
        rxPermissions.requestEach(Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.name.equalsIgnoreCase(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                            if (permission.granted) {//同意后调用
                                doDown();
                            } else if (permission.shouldShowRequestPermissionRationale) {//禁止，但没有选择“以后不再询问”，以后申请权限，会继续弹出提示
                            } else {//禁止，但选择“以后不再询问”，以后申请权限，不会继续弹出提示
                            }
                        }
                    }
                });
    }

    private void doDown() {

    }

    private void doPost() {
        OkGo.<String>post("http://www.baidu.com")
                .tag(this)
                .cacheKey("cachePostKey")
                .cacheMode(CacheMode.DEFAULT)
                .upJson("")
                .params("param2", "paramValue2")
                .params("param3", "paramValue3")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Toast.makeText(MainActivity.this, response.body(), Toast.LENGTH_SHORT).show();
                        Log.i("====",response.body());

                    }
                });
    }

    private void doGet() {
        OkGo.<String>get("http://www.baidu.com")                            // 请求方式和请求url
                .tag(this)                       // 请求的 tag, 主要用于取消对应的请求
                .cacheKey("cacheKey")            // 设置当前请求的缓存key,建议每个不同功能的请求设置一个
                .cacheMode(CacheMode.DEFAULT)    // 缓存模式，详细请看缓存介绍
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Toast.makeText(MainActivity.this, response.body(), Toast.LENGTH_SHORT).show();
                        Log.i("====",response.body());
                    }
                });
    }
}
