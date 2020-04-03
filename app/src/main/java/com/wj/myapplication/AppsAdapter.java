package com.wj.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

/**
 * author wangjing
 * Date 2019/6/19
 * Description
 */
public class AppsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    public AppsAdapter(Context context) {
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        viewHolder = new MyAppHolder(LayoutInflater.from(context).inflate(R.layout.app_list_item, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final MyAppHolder myAppHolder = (MyAppHolder) holder;
    }


    @Override
    public int getItemCount() {
        return 100;
    }

    public class MyAppHolder extends RecyclerView.ViewHolder {

        public MyAppHolder(View view) {
            super(view);
        }

    }
}
