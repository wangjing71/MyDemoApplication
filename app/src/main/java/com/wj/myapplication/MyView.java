package com.wj.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * author wangjing
 * Date 2020/4/10
 * Description
 */
public class MyView extends View {
    private Paint paint;

    private RectF mRectf;

    private int length;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        length = getWidth();
        mRectf = new RectF((float) (length * 0.1),(float) (length * 0.1),(float) (length * 0.9),(float) (length * 0.9));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(length/2,length/2,length/4,paint);
    }
}
