package com.wj.myapplication.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wj.myapplication.R;
import com.wj.myapplication.base.BaseFragment;


/**
 * author wangjing
 * Date 2019/6/24
 * Description 金库钥匙
 */
public class KeyFragment extends BaseFragment {

    private TextView title;
    private ImageView right;

    //需要无参构造方法
    public KeyFragment() {
    }

    @Override
    public int setContentViewId() {
        return R.layout.fragment_key;
    }

    @Override
    public void initView(View root) {
        title = root.findViewById(R.id.title);
        right = root.findViewById(R.id.right);
    }

}
