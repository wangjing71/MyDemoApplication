package com.wj.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * author wangjing
 * Date 2019/10/24
 * Description
 */
public class ZhizhuView extends View {
    private Paint mPaint = new Paint();

    public ZhizhuView(Context context) {
        super(context);
        initPaint();
    }

    public ZhizhuView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public ZhizhuView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    // 2.初始化画笔
    private void initPaint() {
        mPaint.setColor(Color.RED);       //设置画笔颜色
        mPaint.setStyle(Paint.Style.STROKE);  //设置画笔模式为填充
        mPaint.setStrokeWidth(10f);         //设置画笔宽度为10px
    }
}
