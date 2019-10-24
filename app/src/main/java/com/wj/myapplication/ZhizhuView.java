package com.wj.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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

    private int count = 6;                //数据个数
    private double angle = (Math.PI * 2 / count);

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
        mPaint.setStrokeWidth(5.0f);         //设置画笔宽度为10px
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(getWidth() / 2, getHeight() / 2);  // 移动坐标系到屏幕中心
        canvas.scale(1, -1);

        Path path = new Path();
        for (int i = 0; i < 6; i++) {
            float r = (100 + 20 * i);
            path.moveTo(r, 0);
            path.lineTo(r / 2, (float) (r * Math.sin(angle)));
            path.lineTo(-r / 2, (float) (r * Math.sin(angle)));
            path.lineTo(-r, 0);
            path.lineTo(-r / 2, -(float) (r * Math.sin(angle)));
            path.lineTo(r / 2, -(float) (r * Math.sin(angle)));
            path.close();
            canvas.drawPath(path, mPaint);
        }
    }
}
