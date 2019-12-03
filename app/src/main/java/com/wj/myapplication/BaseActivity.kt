package com.wj.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


/**
 * Created by Administrator on 2018/1/4.
 */

abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        initView()
        initData()
        setEvent()
    }

    protected abstract fun setLayoutId(): Int
    protected abstract fun initView()
    protected abstract fun initData()
    protected abstract fun setEvent()
}