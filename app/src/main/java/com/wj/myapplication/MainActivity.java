package com.wj.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;


import dsfsdf.wj.sdfsf.myapplication.R;


public class MainActivity extends BaseActivity {


    private String info = "我是安卓原生的弹框，通过js调用";
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
        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setAllowFileAccess(true);// 设置允许访问文件数据
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.addJavascriptInterface(new JiaoHu(),"hello");

        webView.loadUrl("http://192.168.3.111:8080/");


        Button btn = (Button) findViewById(R.id.get_js);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("javascript:gotos('我是从安卓传递的参数')");
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
        public void openKefu(){
            Toast.makeText(MainActivity.this,info,Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,SecondActivity.class));
        }
    }
}

