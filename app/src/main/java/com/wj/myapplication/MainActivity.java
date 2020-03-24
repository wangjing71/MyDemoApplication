package com.wj.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity extends BaseActivity {
    private LinearLayout parent;
    private UMExpandLayout umExpandLayout;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        parent = findViewById(R.id.parent);
    }

    @Override
    protected void initData() {
        doSomeThing();

    }

    @Override
    protected void setEvent() {

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSomeThing();
            }
        });


        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                umExpandLayout.toggleExpand();
            }
        });
    }

    private void doSomeThing() {
        umExpandLayout = (UMExpandLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.items_layout,null,false);
        LinearLayout content = umExpandLayout.findViewById(R.id.content);
        View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.item1, null, false);
        content.addView(view1);
        View view2 = LayoutInflater.from(MainActivity.this).inflate(R.layout.item1, null, false);
        content.addView(view2);
        View view3 = LayoutInflater.from(MainActivity.this).inflate(R.layout.item1, null, false);
        content.addView(view3);

        parent.addView(umExpandLayout,3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        umExpandLayout.toggleExpand();

        umExpandLayout.expandDelayed(200);
    }
}
