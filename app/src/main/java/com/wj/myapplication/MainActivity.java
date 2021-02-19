package com.wj.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xuexiang.xui.widget.guidview.FocusShape;
import com.xuexiang.xui.widget.guidview.GuideCaseView;
import com.xuexiang.xui.widget.guidview.OnViewInflateListener;


public class MainActivity extends BaseActivity {

    private Button button;
    private GuideCaseView guideCaseView;
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
        guideCaseView = new GuideCaseView.Builder(this)
                .focusOn(button)
                .focusShape(FocusShape.ROUNDED_RECTANGLE)
                .roundRectRadius(20)
                .disableFocusAnimation()
                .customView(R.layout.layout_custom_guide_case_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view12) {
                        view12.findViewById(R.id.btn_action_close).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view1) {
                                guideCaseView.hide();
                            }
                        });
                    }
                })
                .closeOnTouch(false)
                .build();
        guideCaseView.show();
    }

    @Override
    protected void setEvent() {
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                doSomeThing();
//            }
//        });
    }

    private void doSomeThing() {

    }
}
