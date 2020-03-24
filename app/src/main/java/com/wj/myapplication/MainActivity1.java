package com.wj.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity1 extends BaseActivity {
    private LinearLayout parent;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main_1;
    }

    @Override
    protected void initView() {
        parent = findViewById(R.id.parent);
    }

    @Override
    protected void initData() {
        View view1 = LayoutInflater.from(MainActivity1.this).inflate(R.layout.item1, null, false);
        parent.addView(view1);
        moveToTop(0, view1);
        View view2 = LayoutInflater.from(MainActivity1.this).inflate(R.layout.item1, null, false);
        parent.addView(view2);
        moveToTop(500, view2);
    }

    @Override
    protected void setEvent() {
    }

    public void moveToTop(long startDelay, View view) {
        ObjectAnimator translationY = new ObjectAnimator().ofFloat(view, "translationY", 600, 0);
        AnimatorSet animatorSet = new AnimatorSet();  //组合动画
        animatorSet.playTogether(translationY); //设置动画
        animatorSet.setDuration(500);  //设置动画时间
        animatorSet.setStartDelay(startDelay);
        animatorSet.start(); //启动
    }
}
