package com.wj.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * author wangjing
 * Date 2019/8/16
 * Description
 */
public class MyTextView extends AppCompatTextView {
    private Paint paint1, paint2;
    private int mViewWidth;
    private Matrix matrix;
    private int mTransLate;
    private LinearGradient linearGradient;

    public MyTextView(Context context) {
        super(context);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint1 = new Paint();
        paint1.setColor(Color.RED);
        paint1.setStyle(Paint.Style.FILL);

        paint2 = new Paint();
        paint2.setColor(Color.YELLOW);
        paint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                Paint paint = getPaint();
                linearGradient = new LinearGradient(
                        0,
                        0,
                        mViewWidth,
                        0,
                        new int[]{Color.BLUE, 0xffff00ff, Color.BLUE},
                        null,
                        Shader.TileMode.CLAMP
                );
                paint.setShader(linearGradient);
                matrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint1);
        canvas.drawRect(2, 2, getMeasuredWidth() - 2, getMeasuredHeight() - 2, paint2);
        canvas.save();
//        canvas.translate(0, 10);
        super.onDraw(canvas);
        canvas.restore();

        if(matrix != null){
            mTransLate += mViewWidth/5;
            if(mTransLate>2*mViewWidth){
                mTransLate = -mViewWidth;
            }
            matrix.setTranslate(mTransLate,0);
            linearGradient.setLocalMatrix(matrix);
            postInvalidateDelayed(100);
        }
    }
}
