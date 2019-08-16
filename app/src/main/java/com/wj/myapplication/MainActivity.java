package com.wj.myapplication;

import android.os.Bundle;
import android.widget.Button;

import com.wj.myapplication.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {


    @BindView(R.id.button1)
    Button button1;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

}
