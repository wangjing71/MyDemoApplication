package com.wj.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    List<String> mStringList;
    RecyAdapter mRecyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_grid);
        initRecy();
    }

    private void initRecy() {
        if (mStringList == null) {
            mStringList = new ArrayList<>();
        }
        mStringList.addAll(DataManager.getData(9));
        mRecyAdapter = new RecyAdapter(R.layout.item_grid_view, mStringList, true);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        mRecyclerView.setHasFixedSize(true);

        RecyItemTouchHelperCallback itemTouchHelperCallback = new RecyItemTouchHelperCallback(mRecyAdapter, false, true);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchHelperCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

        mRecyclerView.addOnItemTouchListener(new OnRecyclerItemClickListener(mRecyclerView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder viewHolder) {
                RecyAdapter.ViewHolder viewHolder1 = (RecyAdapter.ViewHolder) viewHolder;
                String tvString = viewHolder1.mTextView.getText().toString();
                Toast.makeText(GridViewActivity.this, "点击了..." + tvString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder viewHolder) {
                Toast.makeText(GridViewActivity.this, "" + "长按拖动...", Toast.LENGTH_SHORT).show();
                if (viewHolder.getLayoutPosition() != 2) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        mRecyclerView.setAdapter(mRecyAdapter);
    }


}

