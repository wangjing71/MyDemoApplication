package com.wj.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ImmersionBar
import com.gyf.immersionbar.ktx.immersionBar
import com.tbruyelle.rxpermissions2.RxPermissions

/**
 * Created by Administrator on 2018/1/4.
 */
abstract class BaseActivity : AppCompatActivity() {
    protected var rxPermissions: RxPermissions? = null
    private var barView: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        rxPermissions = RxPermissions(this)
        barView = findViewById(R.id.barView)
        immersionBar {
            statusBarColor(R.color.colorPrimary)
            init()
            statusBarView(barView)
        }

        initView()
        initData()
        setEvent()
    }

    protected abstract fun setLayoutId(): Int
    protected abstract fun initView()
    protected abstract fun initData()
    protected abstract fun setEvent()
}