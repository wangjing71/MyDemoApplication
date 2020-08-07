package com.wj.myapplication;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Description:
 * Data：7/10/2018-10:18 AM
 *
 * @author yanzhiwen
 */

public class CustomInputView extends LinearLayout implements View.OnClickListener {

    public CustomInputView(Context context) {
        this(context, null);
    }

    public CustomInputView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomInputView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.costomer_keyboard, this);
        setItemClickListener(this);
    }

    /**
     * 给每一个自定义数字键盘上的View 设置点击事件
     *
     * @param view
     */
    private void setItemClickListener(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                //不断的给里面所有的View设置setOnClickListener
                View childView = ((ViewGroup) view).getChildAt(i);
                setItemClickListener(childView);
            }
        } else {
            view.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (v instanceof TextView) {
            String number = ((TextView) v).getText().toString().trim();
            if(onInputStr!=null){
                onInputStr.inputNumber(number);
            }
        }
        if (v instanceof ImageView) {
            if(onInputStr!=null){
                onInputStr.delete();
            }
        }
    }
    onInputStr onInputStr;

    public void setOnInputStr(CustomInputView.onInputStr onInputStr) {
        this.onInputStr = onInputStr;
    }

    interface onInputStr{
        void inputNumber(String num);
        void delete();
    }
}
