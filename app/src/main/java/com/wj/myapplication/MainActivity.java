package com.wj.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends BaseActivity {

//    private Button button;
    private LinearLayout parent;

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
        DragView.addDragView(this,parent,R.layout.drag_view);
    }

    @Override
    protected void setEvent() {

    }

}
