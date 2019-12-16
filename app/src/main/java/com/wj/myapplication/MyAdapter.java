package com.wj.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author wangjing
 * Date 2019/12/16
 * Description
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Integer> mList = new ArrayList();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        viewHolder = new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        TextView tv_text;

        public ItemHolder(View view) {
            super(view);
            tv_text = view.findViewById(R.id.tv_text);
        }
    }

}
