package com.wj.myapplication;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;

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
                        if (aBoolean) {
                            Intent jumpIntent = new Intent(Intent.ACTION_PICK);
                            jumpIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                            startActivityForResult(jumpIntent, SELECT_CONTACT);
                        }
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case SELECT_CONTACT:
                    //选择通讯录联系人返回
                    if (data == null) {
                        return;
                    }
                    try {
                        if (data.getData() != null) {
                            Cursor cursor = getContentResolver()
                                    .query(data.getData(),
                                            new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME},
                                            null, null, null);

                            while (cursor.moveToNext()) {
                                String name = cursor.getString(1).replaceAll(" ", "");
                                //取出该条数据的联系人的手机号
                                String number = cursor.getString(0).replaceAll(" ", "").replaceAll("-", "");
                                Toast.makeText(this, name + "_" + number, Toast.LENGTH_SHORT).show();
                            }
                            cursor.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                 default:
                    break;
            }
        }
    }
}
