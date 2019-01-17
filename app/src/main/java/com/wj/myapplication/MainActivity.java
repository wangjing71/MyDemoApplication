package com.wj.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class MainActivity extends BaseActivity {

    private TagFlowLayout flowLayout;
    private List<String> datas = new ArrayList<>();
    private String[] mVals = new String[]
            {"积分兑换", "iPhoneXS", "0元百兆宽带", "小魔卡", "超值定向视频流量", "限免影院",
                    "积分兑换", "iPhoneXS", "0元百兆宽带", "小魔卡", "超值定向视频流量", "限免影院",
                    "积分兑换", "iPhoneXS", "0元百兆宽带", "小魔卡", "超值定向视频流量", "限免影院"};

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
        flowLayout = findViewById(R.id.id_flowlayout);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < mVals.length; i++) {
            datas.add(mVals[i]);
        }
        flowLayout.setAdapter(new TagAdapter<String>(datas) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(MainActivity.this).inflate(R.layout.tv,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }

            @Override
            public boolean setSelected(int position, String s) {
                return s.equals("Android");
            }
        });

    }

    @Override
    protected void setEvent() {
        flowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(MainActivity.this, mVals[position], Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void doSomeThing() {

    }
}
