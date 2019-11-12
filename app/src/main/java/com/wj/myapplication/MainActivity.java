package com.wj.myapplication;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends BaseActivity {
    private RecyclerView recyclerView1;
    private MyAdapter adapter1;
    private ArrayList<Integer> dataList1 = new ArrayList<>();
    private ArrayList<Integer> dataList2 = new ArrayList<>();
    private ArrayList<Integer> dataList3 = new ArrayList<>();


    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        recyclerView1 = findViewById(R.id.mRecyclerView1);
    }

    @Override
    protected void initData() {
        setData();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(manager);
        adapter1 = new MyAdapter(this);
        adapter1.setDataList(dataList1);
        recyclerView1.setAdapter(adapter1);

    }

    private void setData() {
        dataList1.add(R.mipmap.bg_1_back_01);
        dataList1.add(R.mipmap.bg_1_back_02);
        dataList1.add(R.mipmap.bg_1_back_03);
        dataList1.add(R.mipmap.bg_1_back_04);
        dataList1.add(R.mipmap.bg_1_back_05);
        dataList1.add(R.mipmap.bg_1_back_06);
        dataList1.add(R.mipmap.bg_1_back_07);
        dataList1.add(R.mipmap.bg_1_back_08);
        dataList1.add(R.mipmap.bg_1_back_09);
        dataList1.add(R.mipmap.bg_1_back_10);
        dataList1.add(R.mipmap.bg_1_back_11);
        dataList1.add(R.mipmap.bg_1_back_12);
        dataList1.add(R.mipmap.bg_1_back_13);
        dataList1.add(R.mipmap.bg_1_back_14);
    }

    @Override
    protected void setEvent() {
    }

    private void doSomeThing() {

    }
}
