package com.wj.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * author wangjing
 * Date 2019/4/28
 * Description
 */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private Context context;
    private ViewPager pager;
    private LinearLayout tabsContainer;

    private final PageListener pageListener = new PageListener();
    private int tabCount;

    private LinearLayout.LayoutParams defaultTabLayoutParams;
    private LinearLayout.LayoutParams expandedTabLayoutParams;

    public void setViewPager(ViewPager pager) {
        this.pager = pager;
        if (pager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }

        pager.addOnPageChangeListener(pageListener);

        notifyDataSetChanged();
    }

    public PagerSlidingTabStrip(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        tabsContainer = new LinearLayout(context);
        tabsContainer.setOrientation(LinearLayout.HORIZONTAL);
        tabsContainer.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        addView(tabsContainer);

        defaultTabLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        expandedTabLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1.0f);
    }

    private void notifyDataSetChanged() {
        tabsContainer.removeAllViews();
        tabCount = pager.getAdapter().getCount();


        for (int i = 0; i < tabCount; i++) {
            addTextTab(i, pager.getAdapter().getPageTitle(i).toString());
        }
        updateTabStyles();
    }

    private void addTextTab(int position, String title) {
        TextView tab = new TextView(getContext());
        tab.setText(title);
        tab.setTextColor(Color.parseColor("#FF00FF"));
        tab.setGravity(Gravity.CENTER);
        tab.setSingleLine();
        addTab(position, tab);
    }

    private void addTab(int position, View tab) {
        tab.setFocusable(true);
        tabsContainer.addView(tab, position, expandedTabLayoutParams);
    }

    private void updateTabStyles() {
        for (int i = 0; i < tabCount; i++) {
            View v = tabsContainer.getChildAt(i);
            v.setBackgroundColor(Color.parseColor("#FF0000"));
        }
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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
