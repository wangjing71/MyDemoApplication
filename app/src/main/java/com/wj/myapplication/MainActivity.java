package com.wj.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;


public class MainActivity extends BaseActivity {

    private EditText edt1, edt2, edt3, edt4, edt5, edt6;
    private CustomInputView myInput;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        edt4 = findViewById(R.id.edt4);
        edt5 = findViewById(R.id.edt5);
        edt6 = findViewById(R.id.edt6);
//        edt1.setCursorVisible(false);
//        edt2.setCursorVisible(false);
//        edt3.setCursorVisible(false);
//        edt4.setCursorVisible(false);
//        edt5.setCursorVisible(false);
//        edt6.setCursorVisible(false);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
        edtFocusChangeInit(edt1, null, edt2);
        edtFocusChangeInit(edt2, edt1, edt3);
        edtFocusChangeInit(edt3, edt2, edt4);
        edtFocusChangeInit(edt4, edt3, edt5);
        edtFocusChangeInit(edt5, edt4, edt6);
        edtFocusChangeInit(edt6, edt5, null);

        myInput.setOnInputStr(new CustomInputView.onInputStr() {
            @Override
            public void inputNumber(String num) {
                Toast.makeText(MainActivity.this, num, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void delete() {
                Toast.makeText(MainActivity.this, "delete", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showJianPan();
            }
        });
    }

    private void edtFocusChangeInit(EditText main, final EditText pre, final EditText last) {
        main.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i("====", "beforeTextChanged");

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i("====", "onTextChanged");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.i("====", "afterTextChanged");
                int length = editable.length();
                if (length == 1) {
                    if (last != null) {
                        last.requestFocus();
                    }
                }
                if (length == 0) {
                    if (pre != null) {
                        pre.requestFocus();
                    }
                }


            }
        });
    }

    public void showJianPan(){
        View popview = LayoutInflater.from(this).inflate(R.layout.costomer_keyboard, null, false);
        final PopupWindow window = new PopupWindow(popview, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.setOutsideTouchable(true);
        window.setTouchable(true);
        window.setAnimationStyle(R.style.change_business_anim_style);
        window.showAtLocation(popview, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }
}
