package com.wj.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xuexiang.xui.XUI;
import com.xuexiang.xui.widget.dialog.materialdialog.MaterialDialog;

import static com.xuexiang.xui.XUI.getContext;


public class MainActivity extends BaseActivity {

    private Button button;
    private LoadingView loadingView;
    private IOSLoadingView iosLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        button = findViewById(R.id.button);
        loadingView = findViewById(R.id.load);
        iosLoadingView = findViewById(R.id.iosLoadingView);

        loadingView.start();
        iosLoadingView.start();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSomeThing();
            }
        });
    }

    private void doSomeThing() {
        new MaterialDialog.Builder(getContext())
                .content("111111111111")
                .positiveText("是")
                .negativeText("否")
                .show();
    }
}
