package com.wj.myapplication.safe;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.wj.myapplication.MainActivity;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/7/25.
 */
public class CheckUtils {

    private static CheckUtils checkUtils = null;

    // 双重检查
    public static CheckUtils getInstance() {
        if (checkUtils == null) {
            synchronized (CheckUtils.class) {
                if (checkUtils == null) {
                    checkUtils = new CheckUtils();
                }
            }
        }
        return checkUtils;
    }

    private CheckUtils() {
    }

    public void checkSafe(final Activity activity, final SafeCallback safeCallback) {
        if (RootUtils.isRoot()) {
            android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
            alertDialogBuilder.setTitle("温馨提示").setMessage("设备已Root，请谨慎使用！").setPositiveButton("退出", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    activity.finish();
                }
            }).setNegativeButton("继续", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    checkDoubleOpen(activity, safeCallback);
                }
            }).setCancelable(false).show();
        } else {
            checkDoubleOpen(activity, safeCallback);
        }
    }

    /*
     * 检查双开
     * */
    private void checkDoubleOpen(final Activity activity, final SafeCallback safeCallback) {
        VirtualApkCheckUtil.getSingleInstance().checkByCreateLocalServerSocket(activity.getPackageName(), new VirtualCheckCallback() {
            @Override
            public void findSuspect() {
                android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
                alertDialogBuilder.setTitle("温馨提示").setMessage("检测到您正在进行双开操作，请退出！").setPositiveButton("退出", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        activity.finish();
                    }
                }).setNegativeButton("继续", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        checkEmulator(activity, safeCallback);
                    }
                }).setCancelable(false).show();
            }

            @Override
            public void next() {
                checkEmulator(activity, safeCallback);
            }
        });
    }

    /*
     * 检查模拟器
     * */
    private void checkEmulator(final Activity activity, final SafeCallback safeCallback) {
        boolean isEmulator = EmulatorCheckUtil.getSingleInstance().readSysProperty(activity, new EmulatorCheckCallback() {
            @Override
            public void findEmulator(String emulatorInfo) {
            }
        });

        if (isEmulator) {
            android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
            alertDialogBuilder.setTitle("温馨提示").setMessage("检测到您正在模拟器运行本软件，请退出！").setPositiveButton("退出", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    activity.finish();
                }
            }).setNegativeButton("继续", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    if (safeCallback != null) {
                        safeCallback.next();
                    }
                }
            }).setCancelable(false).show();
        } else {
            if (safeCallback != null) {
                safeCallback.next();
            }
        }
    }
}
