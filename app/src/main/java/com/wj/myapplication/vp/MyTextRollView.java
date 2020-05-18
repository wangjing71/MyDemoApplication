package com.wj.myapplication.vp;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    private RollViewItemClick rollViewItemClick;
    private int initIndex = 0; //初始位置
    private long rollTime = 1000; //轮播时间
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {

            }
        }
    };

    public void setInitIndex(int initIndex) {
        this.initIndex = initIndex;
        handler.sendEmptyMessageDelayed(0, rollTime);
    }

    public void setRollTime(long rollTime) {
        this.rollTime = rollTime;
    }

    public void setRollViewItemClick(RollViewItemClick rollViewItemClick) {
        this.rollViewItemClick = rollViewItemClick;
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
        adapter.setOnTvItemClick(new TvItemClick() {
            @Override
            public void itemClick(int position) {
                if (rollViewItemClick != null) {
                    rollViewItemClick.itemClick(position);
                }
            }
        });
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
//            Typeface typeFace = Typeface.createFromAsset(context.getAssets(), "fonts/MUYAO_SOFTBRUSH.TTF");
//            tips.setTypeface(typeFace);
            tips.setText(dataStrList.get(position));
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onTvItemClick != null) {
                        onTvItemClick.itemClick(position);
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

        public TvItemClick onTvItemClick;

        public void setOnTvItemClick(TvItemClick onTvItemClick) {
            this.onTvItemClick = onTvItemClick;
        }
    }

    public interface TvItemClick {
        void itemClick(int position);
    }

    public interface RollViewItemClick {
        void itemClick(int position);
    }
}
