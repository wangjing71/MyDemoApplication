package com.wj.myapplication

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

import com.tbruyelle.rxpermissions2.Permission
import com.tbruyelle.rxpermissions2.RxPermissions

import java.util.regex.Matcher
import java.util.regex.Pattern

import io.reactivex.functions.Consumer


class MainActivity : BaseActivity() {

    var button: Button? = null

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        button = findViewById(R.id.button)
    }

    override fun initData() {}

    override fun setEvent() {
        button!!.setOnClickListener { doSomeThing() }
    }

    fun doSomeThing() {
        val rxPermissions = RxPermissions(this)
        rxPermissions.requestEach(Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS)
                .subscribe { permission ->
                    if (permission.name.equals(Manifest.permission.ACCESS_FINE_LOCATION, ignoreCase = true)) {
                        if (permission.granted) {//同意后调用
                        } else if (permission.shouldShowRequestPermissionRationale) {//禁止，但没有选择“以后不再询问”，以后申请权限，会继续弹出提示
                        } else {//禁止，但选择“以后不再询问”，以后申请权限，不会继续弹出提示
                        }
                    }
                }
        Toast.makeText(this, "hello world!", Toast.LENGTH_SHORT).show()
    }

}
