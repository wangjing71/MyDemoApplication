package com.wj.myapplication;

import android.util.Log;
import android.view.View;

import com.angcyo.tablayout.DslTabLayout;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private AppsAdapter appsAdapter;
    private DslTabLayout dslTabLayout;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        dslTabLayout = findViewById(R.id.dsl_tabLayout);
    }

    @Override
    protected void initData() {
        appsAdapter = new AppsAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(appsAdapter);

    }

    @Override
    protected void setEvent() {
        dslTabLayout.getTabLayoutConfig().setOnSelectIndexChange(new Function3<Integer, List<Integer>, Boolean, Unit>() {
            @Override
            public Unit invoke(Integer fromIndex, List<Integer> selectIndexList, Boolean reselect) {
                int toIndex = selectIndexList.get(0);
                Log.i("====",toIndex+"");
                return null;
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState){
                super.onScrollStateChanged(recyclerView, newState);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                //判断是当前layoutManager是否为LinearLayoutManager
                // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                    //获取第一个可见view的位置
                    int firstItemPosition = linearManager.findFirstVisibleItemPosition();
                    //获取最后一个可见view的位置
                    int lastItemPosition = linearManager.findLastVisibleItemPosition();
                    Log.i("====",firstItemPosition+"____"+lastItemPosition);
                    dslTabLayout.setCurrentItem(firstItemPosition,true);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

    }
}
