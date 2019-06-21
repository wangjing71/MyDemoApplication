package com.wj.myapplication;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Arrays;
import java.util.List;

/**
 * Created by gyq on 2017/9/8 09:59
 */
public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {
    private int item_layout;
    private List<String> mDataList;
    private List<Integer> mInts;
    private boolean isFirstSpecial;

    public RecyAdapter(int item_layout, List<String> dataList) {
        this.item_layout = item_layout;
        mDataList = dataList;
        mInts = Arrays.asList(R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
    }

    public RecyAdapter(int item_layout, List<String> dataList, boolean isFirstSpecial) {
        this(item_layout, dataList);
        this.isFirstSpecial = isFirstSpecial;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String string = mDataList.get(position);
        if (isFirstSpecial && position == 0) {
            holder.itemView.setBackgroundColor(Color.LTGRAY);
            holder.mTextView.setText("精选");
            holder.mImageView.setImageResource(R.mipmap.ic_launcher);
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE);
            holder.mTextView.setText(string);
            holder.mImageView.setImageResource(mInts.get(position % mInts.size()));
        }
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    public List<String> getDataList() {
        return mDataList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        ImageView mImageView;

        ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_item);
            mImageView = (ImageView) itemView.findViewById(R.id.img_item);
        }
    }
}

