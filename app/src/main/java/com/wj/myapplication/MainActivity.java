package com.wj.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends BaseActivity {

    private Button button;
    private String base;
    private ImageView imageView;

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
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.show);
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
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.activity_home3_tip);
        base = Base64BitmapUtil.bitmapToBase64(bitmap);
        Log.i("====",base);

        imageView.setImageBitmap(Base64BitmapUtil.base64ToBitmap(base));
    }
}
