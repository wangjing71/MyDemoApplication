package com.wj.myapplication;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * author wangjing
 * Date 2019/4/28
 * Description
 */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private ViewPager mViewPager;

    private final PageListener pageListener = new PageListener();

    public void setmViewPager(ViewPager mViewPager) {
        this.mViewPager = mViewPager;
        if (mViewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }

        mViewPager.addOnPageChangeListener(pageListener);

        notifyDataSetChanged();
    }

    public PagerSlidingTabStrip(Context context) {
        super(context);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void notifyDataSetChanged() {



    }
    private class PageListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
