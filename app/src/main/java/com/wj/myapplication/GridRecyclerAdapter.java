package com.wj.myapplication;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class GridRecyclerAdapter extends PinnedHeaderAdapter<RecyclerView.ViewHolder> {

    public static final int VIEW_TYPE_ITEM_TIME = 0;
    private static final int VIEW_TYPE_ITEM_CONTENT = 1;

    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    private List<ItemBean> mDataList;

    public GridRecyclerAdapter() {
        this(null);
    }

    public GridRecyclerAdapter(List<ItemBean> dataList) {
        mDataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM_TIME) {
            return new TitleHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_title, parent, false));
        } else {
            return new ContentHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_content, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_ITEM_TIME) {
            TitleHolder titleHolder = (TitleHolder) holder;
            ArrayList<Fragment> frameLayoutArrayList = new ArrayList<>();
            titleHolder.dotll.removeAllViews();
            for (int i = 0; i < 4; i++) {
                View view = LayoutInflater.from(context).inflate(R.layout.item_title,null,false);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                params.weight = 1.0f;
                params.leftMargin = context.getResources().getDimensionPixelSize(R.dimen.dp_2);
                params.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.dp_2);
                view.setLayoutParams(params);
                TextView tv = view.findViewById(R.id.title);
                tv.setText("条目"+i);
                titleHolder.dotll.addView(view);


                frameLayoutArrayList.add(new BusinessItemFragment());
            }

            MyBusinessItemAdapter myBusinessItemAdapter = new MyBusinessItemAdapter(((FragmentActivity)context).getSupportFragmentManager(),frameLayoutArrayList);
            titleHolder.viewPager.setOffscreenPageLimit(3);
            titleHolder.viewPager.setAdapter(myBusinessItemAdapter);

        } else {
            ContentHolder contentHolder = (ContentHolder) holder;
            Picasso.with(contentHolder.mImage.getContext()).load(mDataList.get(position).getDat()).into(contentHolder.mImage);
        }
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataList.get(position).getType() == 0) {
            return VIEW_TYPE_ITEM_TIME;
        } else {
            return VIEW_TYPE_ITEM_CONTENT;
        }
    }

    @Override
    public boolean isPinnedPosition(int position) {
        return getItemViewType(position) == VIEW_TYPE_ITEM_TIME;
    }

    static class ContentHolder extends RecyclerView.ViewHolder {

        CircleImageView mImage;

        ContentHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image_icon);
        }
    }

    static class TitleHolder extends RecyclerView.ViewHolder {

        LinearLayout dotll;
        ViewPager viewPager;

        TitleHolder(View itemView) {
            super(itemView);
            dotll = itemView.findViewById(R.id.dotll);
            viewPager = itemView.findViewById(R.id.mViewPager);
        }
    }

}
