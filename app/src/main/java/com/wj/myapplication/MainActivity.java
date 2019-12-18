package com.wj.myapplication;


import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends BaseActivity {

    private ViewPager2 viewPager2;
    private MyAdapter myAdapter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        myAdapter = new MyAdapter();
        myAdapter.setData(null);
        viewPager2.setAdapter(myAdapter);

        //禁止滑动 可以通过代码模拟滑动
//        viewPager2.setUserInputEnabled(false);


        ConstraintLayout parent = findViewById(R.id.cl_main);
        parent.setClipChildren(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(2);

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) viewPager2.getLayoutParams();
        params.leftMargin = (int) getResources().getDimension(R.dimen.dp_20);
        params.rightMargin = params.leftMargin;
        viewPager2.setLayoutParams(params);

        //设置间距
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new ScaleInTransformer());
        compositePageTransformer.addTransformer(new MarginPageTransformer((int) getResources().getDimension(R.dimen.dp_30)));
        viewPager2.setPageTransformer(compositePageTransformer);

        viewPager2.setPageTransformer(new MarginPageTransformer((int) getResources().getDimension(R.dimen.dp_10)));

//        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);

    }

    @Override
    protected void setEvent() {
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Toast.makeText(MainActivity.this, position + "", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
