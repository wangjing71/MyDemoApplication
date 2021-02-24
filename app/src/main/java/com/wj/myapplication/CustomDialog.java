package com.wj.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

/**
 * author wangjing
 * Date 2019/4/8
 * Description
 */
public class CustomDialog extends Dialog {

    public CustomDialog(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        setContentView(R.layout.dialog_layout);

        Context context = getContext();
        int divierId = context.getResources().getIdentifier("android:id/titleDivider", null, null);
        View divider = findViewById(divierId);
        if (divider != null) {
            divider.setBackgroundColor(Color.TRANSPARENT);
        }
        Window window = getWindow();
        window.setWindowAnimations(R.style.mainfstyle);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(context.getResources().getDisplayMetrics().widthPixels * 4 / 5, LinearLayout.LayoutParams.WRAP_CONTENT);
    }
}
