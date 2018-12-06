package com.wj.myapplication;

import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;


import dsfsdf.wj.sdfsf.myapplication.R;


public class MainActivity extends BaseActivity {


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
        final WebView webView = findViewById(R.id.mywebview);
        webView.loadUrl("file:///android_asset/webviewtest.html");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JiaoHu(),"hello");

        Button btn = (Button) findViewById(R.id.get_js);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("javascript:android(true)");
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {

    }

    public class JiaoHu{
        @JavascriptInterface
        public void showAndroid(){
            Toast.makeText(MainActivity.this,"js调用了android的方法",Toast.LENGTH_SHORT).show();
        }
    }
}

