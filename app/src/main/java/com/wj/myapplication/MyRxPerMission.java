package com.wj.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;

import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.tbruyelle.rxpermissions2.RxPermissionsFragment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;

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


    public void setLogging(boolean logging) {
        rxPermissions.setLogging(logging);
    }

    public <T> ObservableTransformer<T, Boolean> ensure(final String... permissions) {
        return rxPermissions.ensure(permissions);
    }

    public <T> ObservableTransformer<T, Permission> ensureEach(final String... permissions) {
        return rxPermissions.ensureEach(permissions);
    }

    public <T> ObservableTransformer<T, Permission> ensureEachCombined(final String... permissions) {
        return rxPermissions.ensureEachCombined(permissions);
    }

    public Observable<Boolean> request(String... permissions) {
        return rxPermissions.request(permissions);
    }

    public Observable<Permission> requestEach(String... permissions) {
        return rxPermissions.requestEach(permissions);
    }

    public Observable<Permission> requestEachCombined(String... permissions) {
        return rxPermissions.requestEachCombined(permissions);
    }


    public Observable<Boolean> shouldShowRequestPermissionRationale(Activity activity, String... permissions) {
        return rxPermissions.shouldShowRequestPermissionRationale(activity,permissions);
    }

    public boolean isGranted(String permission) {
        return rxPermissions.isGranted(permission);
    }

    public boolean isRevoked(String permission) {
        return rxPermissions.isRevoked(permission);
    }
}
