package com.wj.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * author wangjing
 * Date 2019/10/10
 * Description
 */
public class ArcImageView extends android.support.v7.widget.AppCompatImageView {
    /*
     *弧形高度
     */
    private int mArcHeight;
    private static final String TAG = "ArcImageView";
    private Paint mPaint;

    public ArcImageView(Context context) {
        this(context, null);
    }

    public ArcImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ArcImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ArcImageView);
        mArcHeight = typedArray.getDimensionPixelSize(R.styleable.ArcImageView_arcHeight, 0);
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#FF00FF"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Path path = new Path();
        path.lineTo(200, getHeight());
        path.quadTo(getWidth() / 2, getHeight() - 2 * mArcHeight, getWidth(), getHeight());
        path.lineTo(getWidth(), 0);
        path.close();
//        canvas.drawPath(path, mPaint);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
