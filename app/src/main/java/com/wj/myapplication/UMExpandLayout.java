package com.wj.myapplication;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * author wangjing
 * Date 2020/3/20
 * Description
 */
public class UMExpandLayout extends RelativeLayout {

    public UMExpandLayout(Context context) {
        this(context, null);
    }

    public UMExpandLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UMExpandLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private View layoutView;
    private int viewHeight;
    private boolean isExpand;
    private long animationDuration;

    private android.os.Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

        }
    };


    private void initView() {
        layoutView = this;
        isExpand = true;
        animationDuration = 500;
        setViewDimensions();
    }

    /**
     * @param isExpand 初始状态是否折叠
     */
    public void initExpand(boolean isExpand) {
        this.isExpand = isExpand;
        if (!isExpand) {
            animateToggle(10);
        }
    }

    /**
     * 设置动画时间
     *
     * @param animationDuration 动画时间
     */
    public void setAnimationDuration(long animationDuration) {
        this.animationDuration = animationDuration;
    }

    /**
     * 获取 subView 的总高度
     * View.post() 的 runnable 对象中的方法会在 View 的 measure、layout 等事件后触发
     */
    private void setViewDimensions() {
        layoutView.post(new Runnable() {
            @Override
            public void run() {
                if (viewHeight <= 0) {
                    viewHeight = layoutView.getMeasuredHeight();
                }
            }
        });
    }

    public static void setViewHeight(View view, int height) {
        final ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = height;
        view.requestLayout();
    }

    /**
     * 切换动画实现
     */
    private void animateToggle(long animationDuration) {
        ValueAnimator heightAnimation = isExpand ?
                ValueAnimator.ofFloat(0f, viewHeight) : ValueAnimator.ofFloat(viewHeight, 0f);
        heightAnimation.setDuration(animationDuration / 2);
        heightAnimation.setStartDelay(animationDuration / 2);

        heightAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float val = (float) animation.getAnimatedValue();
                setViewHeight(layoutView, (int) val);
            }
        });

        heightAnimation.start();
    }

    public boolean isExpand() {
        return isExpand;
    }

    /**
     * 折叠view
     */
    public void collapse() {
        isExpand = false;
        animateToggle(animationDuration);
    }

    /**
     * 展开view
     */
    public void expand() {
        isExpand = true;
        animateToggle(animationDuration);
    }

    /**
     * 展开view
     */
    public void expandDelayed(long delayMillis) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                isExpand = true;
                animateToggle(animationDuration);
            }
        },delayMillis);
    }


    public void toggleExpand() {
        if (isExpand) {
            collapse();
        } else {
            expand();
        }
    }

    /**
     * 重新计算View 高度
     */
    public void reSetViewDimensions() {
        layoutView.post(new Runnable() {
            @Override
            public void run() {
                viewHeight = layoutView.getMeasuredHeight();
            }
        });
    }
}
