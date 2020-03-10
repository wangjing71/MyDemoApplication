package com.wj.myapplication;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParent2;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * author wangjing
 * Date 2020/3/10
 * Description
 */
public class StickyNavLayout extends LinearLayout implements NestedScrollingParent {
    public StickyNavLayout(Context context) {
        super(context);
    }

    public StickyNavLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StickyNavLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        Log.i("====dy", dy+"");
        Log.i("====getScrollY", getScrollY()+"");
        Log.i("====", ViewCompat.canScrollVertically(target, -1)+"");
        boolean hiddenTop = dy > 0 && getScrollY() < 500;
        boolean showTop = dy < 0 && getScrollY() > 0 && !ViewCompat.canScrollVertically(target, -1);
        if(showTop||hiddenTop){
            scrollBy(0, dy);
            consumed[1] = dy;
        }
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return super.onNestedPreFling(target, velocityX, velocityY);
    }
}
