package com.wj.myapplication;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends BaseActivity {

    private Button button;
    private ImageView show;
    private AnimationDrawable animationDrawable1;

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
        animationDrawable1 = new AnimationDrawable();
        int[] ids = {R.mipmap.a0,R.mipmap.a1,R.mipmap.a2,R.mipmap.a3,R.mipmap.a4};
        for(int i = 0 ; i < 4 ; i ++){
            Drawable frame = getResources().getDrawable(ids[i]);
            //设定时长
            animationDrawable1.addFrame(frame,150);
        }
        animationDrawable1.setOneShot(false);
        show.setBackground(animationDrawable1);
        animationDrawable1.setOneShot(true);
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
        animationDrawable1.start();
    }
}
