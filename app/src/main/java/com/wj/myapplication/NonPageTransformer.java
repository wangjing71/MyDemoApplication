package com.wj.myapplication;

import android.view.View;

import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

/**
 * Created by zhy on 16/5/7.
 */
public class NonPageTransformer implements ViewPager2.PageTransformer
{
    @Override
    public void transformPage(View page, float position)
    {
        page.setScaleX(0.999f);//hack
    }

    public static final ViewPager2.PageTransformer INSTANCE = new NonPageTransformer();
}
