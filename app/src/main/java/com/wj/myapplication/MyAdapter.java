package com.wj.myapplication;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


/**
 * author wangjing
 * Date 2018/12/24
 * Description
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Integer> dataList;

    public void setDataList(ArrayList<Integer> dataList) {
        this.dataList = dataList;
    }

    public MyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        viewHolder = new MyItem(LayoutInflater.from(context).inflate(R.layout.item_business, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        MyItem myViewHolder = (MyItem) holder;
        Glide.with(context).load(dataList.get(position)).into(myViewHolder.icon);
    }


    @Override
    public int getItemCount() {
        if(dataList==null){
            return 0;
        }else{
            return dataList.size();
        }
    }


    class MyItem extends RecyclerView.ViewHolder {

        private ImageView icon;


        public MyItem(View view) {
            super(view);
            icon = view.findViewById(R.id.icon);
        }
    }

}
