package com.wj.myapplication;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
            for (int i = 0; i < 4; i++) {
                TextView tv = new TextView(context);
                tv.setText("条目"+i);
                titleHolder.dotll.addView(tv);
            }




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

        TitleHolder(View itemView) {
            super(itemView);
            dotll = itemView.findViewById(R.id.dotll);
        }
    }

}
