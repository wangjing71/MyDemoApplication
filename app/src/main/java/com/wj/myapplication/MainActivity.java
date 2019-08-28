package com.wj.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity {

    private Button button;
    private String parms = "{\"device\":{\"os\":\"android\",\"model\":\"MI 5\",\"osVersion\":26,\"density\":3,\"token\":\"\",\"appVersion\":\"2.3.0\",\"cid\":\"039194fbb0a65c0a\",\"c_id\":\"039194fbb0a65c0a\",\"clientId\":\"1\",\"channelId\":\"YD\",\"protocolId\":\"\"}}";

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        button = findViewById(R.id.button);
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
        HttpRequestUtil.request(this, "", parms, new HttpRequestUtil.StringCallBack() {
            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onFail() {

            }
        });
    }
}
