package com.wj.myapplication;

/**
 * author wangjing
 * Date 2019/12/12
 * Description
 */
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
 * Created by HeTingwei on 2018/6/23.
 */

public class MyImageView extends ImageView {


    private int height;
    private int width;
    private int drawableResource;
    private int startColor;
    private int endColor;
    private Context context;

    public MyImageView(Context context) {
        super(context);
        this.context = context;
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initDrawable(attrs);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;

        initDrawable(attrs);
    }


    private void initDrawable(AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyImageView);
        drawableResource = typedArray.getResourceId(R.styleable.MyImageView_my_drawable, -1);
        startColor = typedArray.getColor(R.styleable.MyImageView_start_color, ContextCompat
                .getColor(context, android.R.color.black));
        endColor = typedArray.getColor(R.styleable.MyImageView_end_color, ContextCompat.getColor
                (context, android.R.color.white));
        typedArray.recycle();
    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), drawableResource);
        Paint paint = new Paint();
        Rect rect = new Rect();
        rect.set(0, 0, getWidth(), getHeight());
        canvas.drawBitmap(changeColor(bitmap,startColor,
                endColor), rect, rect, paint);
    }
    //bitmap是图片的bitmap对象，startColor是左侧颜色，endColor是右侧颜色，
//左到右线型渐变
    private Bitmap changeColor(Bitmap bitmap,int startColor, int endColor) {

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int bitmapArray[] = new int[width * height];
        int count = 0;
        int redB = Color.red(endColor);
        int greenB = Color.green(endColor);
        int blueB = Color.blue(endColor);
        int redW = Color.red(startColor);
        int greenW = Color.green(startColor);
        int blueW = Color.blue(startColor);
        int red, green, blue;
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                green = (int) (greenW * (1 - (float) i / width)
                        + greenB * (float) i / width);
                blue = (int) (blueW * (1 - (float) i / width)
                        + blueB * (float) i / width);
                red = (int) (redW * (1 - (float) i / width)
                        + redB * (float) i / width);
                bitmapArray[count++] = Color.argb(Color.alpha(bitmap.
                        getPixel(i, j)), red, green,blue);
            }
        }
        bitmap.recycle();
        return Bitmap.createBitmap(bitmapArray, width, height,
                Bitmap.Config.ARGB_4444);
    }

    //下面代码增加该类对象可操作
    public int getDrawableResource() {
        return drawableResource;
    }

    public void setDrawableResource(int drawableResource) {
        this.drawableResource = drawableResource;
        invalidate();
    }

    public int getStartColor() {
        return startColor;
    }

    public void setStartColor(int startColor) {
        this.startColor = startColor;
        invalidate();
    }

    public int getEndColor() {
        return endColor;
    }

    public void setEndColor(int endColor) {
        this.endColor = endColor;
        invalidate();
    }
}
