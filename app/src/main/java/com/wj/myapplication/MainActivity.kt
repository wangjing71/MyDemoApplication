package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gyf.barlibrary.ImmersionBar
import com.wj.myapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ImmersionBar.with(this).init()
    }
}
