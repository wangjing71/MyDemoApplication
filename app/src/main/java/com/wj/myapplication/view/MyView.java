package com.wj.myapplication.view;

import android.content.Context;
import android.icu.util.Measure;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * author wangjing
 * Date 2019/8/16
 * Description
 */
public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureSpec(widthMeasureSpec),measureSpec(heightMeasureSpec));
    }

    private int measureSpec(int heightMeasureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);

        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }else{
            result = 10;
            if(specMode == MeasureSpec.AT_MOST){
                result = Math.min(result,specSize);
            }
        }

        return  result;
    }
}
