package com.wj.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * author wangjing
 * Date 2019/8/16
 * Description
 */
public class MyTextView extends AppCompatTextView {
    private Paint paint1,paint2;
    public MyTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
