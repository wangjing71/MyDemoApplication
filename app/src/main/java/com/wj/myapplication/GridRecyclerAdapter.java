package com.wj.myapplication;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    private static final int VIEW_TYPE_ITEM_TAB = 2;

    private Context context;

    private RecyclerView recyclerView;
    private boolean mShouldScroll;
    private int mToPosition = 16;

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

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
        } else if(viewType == VIEW_TYPE_ITEM_CONTENT){
            return new ContentHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_content, parent, false));
        }else if(viewType == VIEW_TYPE_ITEM_TAB){
            return new TabHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_tab, parent, false));
        }else{
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == VIEW_TYPE_ITEM_TIME) {
            TitleHolder titleHolder = (TitleHolder) holder;
            ArrayList<Fragment> frameLayoutArrayList = new ArrayList<>();
            titleHolder.dotll.removeAllViews();
            for (int i = 0; i < 4; i++) {
                View view = LayoutInflater.from(context).inflate(R.layout.item_title, null, false);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                params.weight = 1.0f;
                params.leftMargin = context.getResources().getDimensionPixelSize(R.dimen.dp_2);
                params.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.dp_2);
                view.setLayoutParams(params);
                TextView tv = view.findViewById(R.id.title);
                tv.setText("条目" + i);
                titleHolder.dotll.addView(view);


                frameLayoutArrayList.add(new BusinessItemFragment());
            }

            MyBusinessItemAdapter myBusinessItemAdapter = new MyBusinessItemAdapter(((FragmentActivity) context).getSupportFragmentManager(), frameLayoutArrayList);
            titleHolder.viewPager.setOffscreenPageLimit(3);
            titleHolder.viewPager.setAdapter(myBusinessItemAdapter);

        } else if(type == VIEW_TYPE_ITEM_CONTENT){
            ContentHolder contentHolder = (ContentHolder) holder;
            Picasso.with(contentHolder.mImage.getContext()).load(mDataList.get(position).getDat()).into(contentHolder.mImage);
        }else if(type == VIEW_TYPE_ITEM_TAB){
            TabHolder contentHolder = (TabHolder) holder;
            contentHolder.btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    smoothMoveToPosition(recyclerView,mToPosition);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mDataList.get(position).getType();
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

    static class TabHolder extends RecyclerView.ViewHolder {

        Button btn1;
        Button btn2;
        Button btn3;
        Button btn4;


        TabHolder(View itemView) {
            super(itemView);
            btn1 = itemView.findViewById(R.id.button1);
            btn2 = itemView.findViewById(R.id.button2);
            btn3 = itemView.findViewById(R.id.button3);
            btn4 = itemView.findViewById(R.id.button4);
        }
    }

    private void smoothMoveToPosition(RecyclerView mRecyclerView, final int position) {
        // 第一个可见位置
        int firstItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(0));
        // 最后一个可见位置
        int lastItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1));
        if (position < firstItem) {
            // 第一种可能:跳转位置在第一个可见位置之前
            mRecyclerView.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            // 第二种可能:跳转位置在第一个可见位置之后
            int movePosition = position - firstItem;
            if (movePosition >= 0 && movePosition < mRecyclerView.getChildCount()) {
                int top = mRecyclerView.getChildAt(movePosition).getTop();
                mRecyclerView.smoothScrollBy(0, top);
            }
        } else {
            // 第三种可能:跳转位置在最后可见项之后
            mRecyclerView.smoothScrollToPosition(position);
            mToPosition = position;
            mShouldScroll = true;
        }
    }
}
