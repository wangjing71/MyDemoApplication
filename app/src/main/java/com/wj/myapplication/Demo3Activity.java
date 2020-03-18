package com.wj.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Demo3Activity extends BaseActivity {
    private RecyclerView recyclerView;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_demo3;
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recyclerView_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void initData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyTextAdapter(this));
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"data delete",Snackbar.LENGTH_LONG).setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Demo3Activity.this, "222222222", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }

    @Override
    protected void setEvent() {

    }
}
