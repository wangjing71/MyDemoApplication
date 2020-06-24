package com.wj.myapplication;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import io.reactivex.functions.Consumer;


public class MainActivity extends BaseActivity {

    private static final int SELECT_CONTACT = 1001;
    private Button button;

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
        rxPermissions.request(Manifest.permission.READ_CONTACTS, Manifest.permission.GET_ACCOUNTS)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) {
                        if(aBoolean){
                            Intent jumpIntent = new Intent(Intent.ACTION_PICK);
                            jumpIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                            startActivityForResult(jumpIntent, SELECT_CONTACT);
                        }
                    }
                });
    }
}
