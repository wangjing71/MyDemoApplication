package com.wj.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends BaseActivity {

    //    private Button button;
    private ImageView show;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
//        button = findViewById(R.id.button);
        show = findViewById(R.id.show);
    }

    @Override
    protected void initData() {
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.a);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.b);
        Bitmap bitmap3 = ImageUtil.createWaterMaskBitmap(bitmap1,bitmap2,0,0);
        show.setImageBitmap(bitmap3);
    }

    @Override
    protected void setEvent() {
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                doSomeThing();
//            }
//        });
    }

    private void doSomeThing() {

    }
}
