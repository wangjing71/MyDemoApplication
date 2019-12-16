package com.wj.myapplication;


import android.view.View;
import android.widget.Toast;

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
        viewPager2 = findViewById(R.id.view_pager);
    }

    @Override
    protected void initData() {
        myAdapter = new MyAdapter();
        myAdapter.setData(null);
        viewPager2.setAdapter(myAdapter);

//        viewPager2.setUserInputEnabled(false);
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

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                viewPager2.beginFakeDrag();
//                if (viewPager2.fakeDragBy(-310f)) {
//                    viewPager2.endFakeDrag();
//                }


            }
        });
    }
}
