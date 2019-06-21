package com.wj.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * author wangjing
 * Date 2019/6/21
 * Description
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        viewHolder = new MyEmptyBoxHolder(LayoutInflater.from(context).inflate(R.layout.my_yewu_empty, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class MyEmptyBoxHolder extends RecyclerView.ViewHolder {

        TextView title;

        public MyEmptyBoxHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
        }
    }
}
