package com.wj.myapplication;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;


import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

/**
 * author wangjing
 * Date 2019/5/10
 * Description RxPermission装饰着模式
 */
public class MyRxPerMission extends RxPermissions {
    private RxPermissions rxPermissions;
    private boolean isFirst = true;

    public MyRxPerMission(@NonNull FragmentActivity activity) {
        super(activity);
        rxPermissions = new RxPermissions(activity);
    }

    public MyRxPerMission(@NonNull Fragment fragment) {
        super(fragment);
        rxPermissions = new RxPermissions(fragment);
    }


    public Observable<Boolean> request(String... permissions) {
        if (isFirst) {
            isFirst = false;
            return rxPermissions.request(permissions);
        } else {
            return null;
        }
    }
}
