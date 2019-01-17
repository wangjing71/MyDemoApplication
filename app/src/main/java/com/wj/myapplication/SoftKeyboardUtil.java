package com.wj.myapplication;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


public class SoftKeyboardUtil {

    public static void hideSoft(Context context,View editText){
        if(editText!=null){
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            //隐藏键盘
            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }

    }

    public static void showSoft(Context context,View editText){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        //显示键盘
        imm.showSoftInput(editText, 0);
    }
}
