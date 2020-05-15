package com.wj.myapplication.vp;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wj.myapplication.R;

/**
 * author wangjing
 * Date 2020/5/15
 * Description
 */
public class MyTvPageAdapter extends YPagerAdapter {
    private Context context;

    public MyTvPageAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View item = LayoutInflater.from(context).inflate(R.layout.view_start_page_1, null, false);
        TextView tips = item.findViewById(R.id.textView);
        Typeface typeFace =Typeface.createFromAsset(context.getAssets(),"fonts/MUYAO_SOFTBRUSH.TTF");
        tips.setTypeface(typeFace);
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onBannerTvItemClick!=null){
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

    public onBannerTvItemClick onBannerTvItemClick;

    public void setOnBannerTvItemClick(MyTvPageAdapter.onBannerTvItemClick onBannerTvItemClick) {
        this.onBannerTvItemClick = onBannerTvItemClick;
    }

    public interface onBannerTvItemClick {
        void itemClick(int position);
    }
}
