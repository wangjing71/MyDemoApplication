package com.wj.myapplication;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.Observable;

/**
 * author wangjing
 * Date 2019/5/10
 * Description
 */
public class MyRxPerMission extends RxPermissions {
    private RxPermissions rxPermissions ;

    public MyRxPerMission(@NonNull FragmentActivity activity) {
        super(activity);
        rxPermissions = new RxPermissions(activity);
    }

    public MyRxPerMission(@NonNull Fragment fragment) {
        super(fragment);
        rxPermissions = new RxPermissions(fragment);
    }

    @Override
    public Observable<Boolean> request(String... permissions) {
        Log.i("====","成功装饰");
        return rxPermissions.request(permissions);
    }
}
