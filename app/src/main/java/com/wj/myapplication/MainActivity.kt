package com.example.myapplication

import com.wj.myapplication.BaseActivity
import com.wj.myapplication.R

class MainActivity : BaseActivity() {

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun setEvent() {
    }

    fun getResult(a: Int, b: Int): Int {
        return a + b
    }

    fun getResult1(a: Int, b: Int) = a + b

    fun getResult3(a: Int, b: Int){
        print(a + b)
        if (a > b) {

        }else{

        }
    }
}
