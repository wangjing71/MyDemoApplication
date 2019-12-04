package com.wj.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.wj.myapplication.adapter.HeaderAndFooterWrapper;
import com.wj.myapplication.adapter.SimpleListAdapter;
import com.wj.myapplication.flexible.FlexibleLayout;
import com.wj.myapplication.flexible.callback.OnPullListener;
import com.wj.myapplication.flexible.callback.OnReadyPullListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by gavin
 * date 2018/6/18
 */
public class RecyclerViewActivity extends AppCompatActivity {
    private RelativeLayout loginParent;
    private LinearLayout unLoginParent;
    private boolean haha = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ImmersionBar.with(this).init();
        View statbarHeight = findViewById(R.id.statbarheight);
        View toolBars = findViewById(R.id.toolbars);
        ImmersionBar.setStatusBarView(this, statbarHeight);
        toolBars.getBackground().mutate().setAlpha(0);
        statbarHeight.getBackground().mutate().setAlpha(0);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        View header = LayoutInflater.from(this).inflate(R.layout.header, null);
        loginParent = header.findViewById(R.id.login_parent);
        unLoginParent = header.findViewById(R.id.unlogin_parent);

        View headerImage = header.findViewById(R.id.iv);
        View zhanwei = header.findViewById(R.id.zhanwei);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            list.add("Item : " + i);
        }

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (haha) {
                    haha = false;
                    loginParent.setVisibility(View.GONE);
                    unLoginParent.setVisibility(View.VISIBLE);
                } else {
                    haha = true;
                    loginParent.setVisibility(View.VISIBLE);
                    unLoginParent.setVisibility(View.GONE);
                }
            }
        });

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
        flexibleLayout.setHeader(headerImage);
        flexibleLayout.setZhanwei(zhanwei);

        flexibleLayout.setOnPullListener(new OnPullListener() {
            @Override
            public void onPull(int offset) {
                Log.i("====", offset + "");

            }

            @Override
            public void onRelease() {
                Log.i("====", "onRelease");
            }
        });
    }
}
