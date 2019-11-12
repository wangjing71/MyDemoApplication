package com.wj.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * author wangjing
 * Date 2018/12/24
 * Description
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;


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

    }


    @Override
    public int getItemCount() {
        return 100;
    }


    class MyItem extends RecyclerView.ViewHolder {

        private TextView icon;


        public MyItem(View view) {
            super(view);
            icon = view.findViewById(R.id.icon);
        }
    }

}
