package com.wj.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

/**
 * author wangjing
 * Date 2019/3/6
 * Description
 */
public class MyTextAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> lists;
    private Context context;
    private onItemclickListener onItemclickListener;


    public void setOnItemclickListener(onItemclickListener onItemclickListener) {
        this.onItemclickListener = onItemclickListener;
    }

    public MyTextAdapter(Context context) {
        this.context = context;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        viewHolder = new ItemHolder(LayoutInflater.from(context).inflate(R.layout.activity_my_text_item, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ItemHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
        }
    }

    interface onItemclickListener {
        void itemClick(int position);
    }
}
