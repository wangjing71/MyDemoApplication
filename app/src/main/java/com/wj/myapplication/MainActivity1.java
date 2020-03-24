package com.wj.myapplication;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity1 extends BaseActivity {
    private LinearLayout parent;
    private long animateTime = 200;

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
        moveToTop(animateTime, view2);
        View view3 = LayoutInflater.from(MainActivity1.this).inflate(R.layout.item1, null, false);
        parent.addView(view3);
        moveToTop(animateTime * 2, view3);

        View view4 = LayoutInflater.from(MainActivity1.this).inflate(R.layout.item1, null, false);
        parent.addView(view4);
        moveToTop(animateTime * 3, view4);
    }

    @Override
    protected void setEvent() {

    }

    public void moveToTop(long startDelay, final View view) {
        view.setVisibility(View.GONE);
        ObjectAnimator translationY = new ObjectAnimator().ofFloat(view, "translationY", 600, 0);
        translationY.setStartDelay(10 + startDelay);
        translationY.setDuration(animateTime);
        translationY.start(); //启动

        translationY.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.i("====", "onAnimationStart");
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.i("====", "onAnimationEnd");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.i("====", "onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
