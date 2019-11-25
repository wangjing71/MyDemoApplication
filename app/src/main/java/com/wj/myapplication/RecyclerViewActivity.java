package com.wj.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.gyf.barlibrary.ImmersionBar;
import com.wj.myapplication.adapter.HeaderAndFooterWrapper;
import com.wj.myapplication.adapter.SimpleListAdapter;
import com.wj.myapplication.flexible.FlexibleLayout;
import com.wj.myapplication.flexible.callback.OnReadyPullListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by gavin
 * date 2018/6/18
 */
public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ImmersionBar.with(this).init();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        View header = LayoutInflater.from(this).inflate(R.layout.header, null);
        View headerImage = header.findViewById(R.id.iv);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("Item : " + i);
        }

        SimpleListAdapter adapter = new SimpleListAdapter(this, list);
//        adapter.addHeaderView(header);
        HeaderAndFooterWrapper wrapper = new HeaderAndFooterWrapper(adapter);
        wrapper.addHeaderView(header);

        final LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(wrapper);


        FlexibleLayout flexibleLayout = (FlexibleLayout) findViewById(R.id.fv);
        flexibleLayout.setReadyListener(new OnReadyPullListener() {
            @Override
            public boolean isReady() {
                return manager.findFirstCompletelyVisibleItemPosition() == 0;
            }
        });
        flexibleLayout.setHeader(header);
    }
}
