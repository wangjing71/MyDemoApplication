package com.wj.myapplication;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends BaseActivity {
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private MyAdapter adapter1;
    private MyAdapter adapter2;
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
        recyclerView2 = findViewById(R.id.mRecyclerView2);
    }

    @Override
    protected void initData() {
        setData();

        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(manager1);
        adapter1 = new MyAdapter(this);
        adapter1.setDataList(dataList1);
        recyclerView1.setAdapter(adapter1);

        LinearLayoutManager manager2 = new LinearLayoutManager(this);
        manager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(manager2);
        adapter2 = new MyAdapter(this);
        adapter2.setDataList(dataList2);
        recyclerView2.setAdapter(adapter2);

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

        dataList2.add(R.mipmap.bg_1_middle_01);
        dataList2.add(R.mipmap.bg_1_middle_02);
        dataList2.add(R.mipmap.bg_1_middle_03);
        dataList2.add(R.mipmap.bg_1_middle_04);
        dataList2.add(R.mipmap.bg_1_middle_05);
        dataList2.add(R.mipmap.bg_1_middle_06);
        dataList2.add(R.mipmap.bg_1_middle_07);
        dataList2.add(R.mipmap.bg_1_middle_08);
        dataList2.add(R.mipmap.bg_1_middle_09);
        dataList2.add(R.mipmap.bg_1_middle_10);
        dataList2.add(R.mipmap.bg_1_middle_11);
        dataList2.add(R.mipmap.bg_1_middle_12);
        dataList2.add(R.mipmap.bg_1_middle_13);
        dataList2.add(R.mipmap.bg_1_middle_14);
        dataList2.add(R.mipmap.bg_1_middle_15);
        dataList2.add(R.mipmap.bg_1_middle_16);
        dataList2.add(R.mipmap.bg_1_middle_17);
        dataList2.add(R.mipmap.bg_1_middle_18);
        dataList2.add(R.mipmap.bg_1_middle_19);
        dataList2.add(R.mipmap.bg_1_middle_20);
    }

    @Override
    protected void setEvent() {
    }

    private void doSomeThing() {

    }
}
