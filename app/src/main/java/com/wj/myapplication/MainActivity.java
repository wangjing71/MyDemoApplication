package com.wj.myapplication;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recycler_grid);
    }

    @Override
    protected void initData() {
        final GridLayoutManager manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);

        GridRecyclerAdapter adapter = new GridRecyclerAdapter(obtainData());
        adapter.setContext(this);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new PinnedHeaderItemDecoration());
    }

    @Override
    protected void setEvent() {

    }

    private List<ItemBean> obtainData() {
        List<ItemBean> list = new ArrayList<>();
        list.add(new ItemBean(1,"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=4117837678,3129898700&fm=27&gp=0.jpg"));
        list.add(new ItemBean(1,"https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1514456311&di=2a8ccd6c814c5851fb8763418dd60455&src=http://wenwen.soso.com/p/20130907/20130907174128-2028703867.jpg"));
        list.add(new ItemBean(1,"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1960816299,803825902&fm=27&gp=0.jpg"));
        list.add(new ItemBean(1,"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3790810349,4012335838&fm=27&gp=0.jpg"));
        list.add(new ItemBean(1,"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3781123768,373023027&fm=27&gp=0.jpg"));
        list.add(new ItemBean(1,"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4052445718,1344904722&fm=27&gp=0.jpg"));
        list.add(new ItemBean(1,"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1730874133,3861130981&fm=27&gp=0.jpg"));
        list.add(new ItemBean(1,"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=4117837678,3129898700&fm=27&gp=0.jpg"));
        list.add(new ItemBean(1,"https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1514456311&di=2a8ccd6c814c5851fb8763418dd60455&src=http://wenwen.soso.com/p/20130907/20130907174128-2028703867.jpg"));
        list.add(new ItemBean(1,"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1960816299,803825902&fm=27&gp=0.jpg"));
        list.add(new ItemBean(1,"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3790810349,4012335838&fm=27&gp=0.jpg"));
        list.add(new ItemBean(1,"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3781123768,373023027&fm=27&gp=0.jpg"));
        list.add(new ItemBean(1,"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4052445718,1344904722&fm=27&gp=0.jpg"));
        list.add(new ItemBean(1,"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1730874133,3861130981&fm=27&gp=0.jpg"));
        list.add(new ItemBean(1,"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=4117837678,3129898700&fm=27&gp=0.jpg"));
        list.add(new ItemBean(0,"我是标题"));
        list.add(new ItemBean(1,"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3790810349,4012335838&fm=27&gp=0.jpg"));
        list.add(new ItemBean(1,"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3781123768,373023027&fm=27&gp=0.jpg"));
        list.add(new ItemBean(1,"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4052445718,1344904722&fm=27&gp=0.jpg"));
        list.add(new ItemBean(1,"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1730874133,3861130981&fm=27&gp=0.jpg"));

        return list;
    }
}
