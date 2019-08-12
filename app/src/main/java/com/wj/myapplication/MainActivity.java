package com.wj.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wj.myapplication.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.button, R.id.button1, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button1:
                Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
