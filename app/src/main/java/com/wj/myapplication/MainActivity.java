package com.wj.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;


public class MainActivity extends BaseActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

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
        String mainAccount = "rz_lisr";
        String token = "";  //token随便传
        String serviceId = "SHNGCRM";

        String url = "http://117.135.11.22:8081/portal-4a/"+"user/getToken.do";

        String parms = "";
        try {
            parms = DES3.encode(getRequestParms(serviceId));
        } catch (Exception e) {
            e.printStackTrace();
        }


        OkHttpUtils.postString()
                .url("http://www.baidu.com")
                .content(parms)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(MainActivity.this, "onError", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private  String getRequestParms(String serviceId) {
        JSONObject jsonObject = new JSONObject();
        JSONObject jObject = new JSONObject();
        try {
            jsonObject.put("mainAccount", "rz_lisr");
            jsonObject.put("token", "123");
            jsonObject.put("serviceId", serviceId);
            jObject.put("data", jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jObject.toString();
    }
}
