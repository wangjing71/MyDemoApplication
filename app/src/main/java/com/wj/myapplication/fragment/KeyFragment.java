package com.wj.myapplication.fragment;

import android.view.View;
import android.widget.Button;

import com.wj.myapplication.R;
import com.wj.myapplication.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * author wangjing
 * Date 2019/6/24
 * Description 金库钥匙
 */
public class KeyFragment extends BaseFragment {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.wangjing)
    Button wangjing;

    //需要无参构造方法
    public KeyFragment() {
    }

    @Override
    public int setContentViewId() {
        return R.layout.fragment_key;
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.button, R.id.button1, R.id.button2, R.id.wangjing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                break;
            case R.id.button1:
                break;
            case R.id.button2:
                break;
            case R.id.wangjing:
                break;
        }
    }
}
