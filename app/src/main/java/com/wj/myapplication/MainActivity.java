package com.wj.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends BaseActivity {

    //    private Button button;
    private EditText edt1, edt2, edt3, edt4, edt5, edt6;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
//        button = findViewById(R.id.button);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        edt4 = findViewById(R.id.edt4);
        edt5 = findViewById(R.id.edt5);
        edt6 = findViewById(R.id.edt6);
        edt1.setClickable(false);
        edt2.setClickable(false);
        edt3.setClickable(false);
        edt4.setClickable(false);
        edt5.setClickable(false);
        edt6.setClickable(false);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                doSomeThing();
//            }
//        });
        edtFocusChangeInit(edt1, null, edt2);
        edtFocusChangeInit(edt2, edt1, edt3);
        edtFocusChangeInit(edt3, edt2, edt4);
        edtFocusChangeInit(edt4, edt3, edt5);
        edtFocusChangeInit(edt5, edt4, edt6);
        edtFocusChangeInit(edt6, edt5, null);
    }

    private void edtFocusChangeInit(EditText main, final EditText pre, final EditText last) {
        main.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i("====","beforeTextChanged");

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i("====","onTextChanged");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.i("====","afterTextChanged");
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

    private void doSomeThing() {


    }
}
