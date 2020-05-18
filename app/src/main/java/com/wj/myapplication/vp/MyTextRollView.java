package com.wj.myapplication.vp;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wj.myapplication.R;

import java.util.ArrayList;

/**
 * author wangjing
 * Date 2020/5/18
 * Description
 */
public class MyTextRollView extends LinearLayout {
    private YViewPager viewPager;
    private MyRollPageAdapter adapter;
    private ArrayList<String> dataStrList;
    public TvItemClick TvItemClick;

    public void setTvItemClick(TvItemClick tvItemClick) {
        TvItemClick = tvItemClick;
    }

    public void setDataStrList(ArrayList<String> dataStrList) {
        this.dataStrList = dataStrList;
        setAdapter();
    }

    public MyTextRollView(Context context) {
        super(context);
        init();
    }

    public MyTextRollView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextRollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        viewPager = new YViewPager(getContext());
        viewPager.setDirection(YViewPager.VERTICAL);
        LinearLayout.LayoutParams vp_parms = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        viewPager.setLayoutParams(vp_parms);
        addView(viewPager);
    }

    private void setAdapter() {
        adapter = new MyRollPageAdapter(getContext());
        viewPager.setAdapter(adapter);
        adapter.setOnTvItemClick(TvItemClick);
    }

    class MyRollPageAdapter extends YPagerAdapter {
        private Context context;

        public MyRollPageAdapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, final int position) {
            View item = LayoutInflater.from(context).inflate(R.layout.my_text_roll_view_item, null, false);
            TextView tips = item.findViewById(R.id.textView);
            Typeface typeFace = Typeface.createFromAsset(context.getAssets(), "fonts/MUYAO_SOFTBRUSH.TTF");
            tips.setTypeface(typeFace);
            tips.setText(dataStrList.get(position));
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, position+"", Toast.LENGTH_SHORT).show();
                    if (onBannerTvItemClick != null) {
                        onBannerTvItemClick.itemClick(position);
                    }
                }
            });

            container.addView(item);
            return item;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        public TvItemClick onBannerTvItemClick;

        public void setOnTvItemClick(TvItemClick onBannerTvItemClick) {
            this.onBannerTvItemClick = onBannerTvItemClick;
        }
    }

    interface TvItemClick {
        void itemClick(int position);
    }
}
