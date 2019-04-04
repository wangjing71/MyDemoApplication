package com.wj.myapplication;

import android.os.Environment;

import java.io.File;

/**
 * author wangjing
 * Date 2018/10/22
 * Description SD卡相关辅助工具类
 */
public class SDCardUtils {
    public static String getSDPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED);//判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        }
        return sdDir.toString()+ File.separator;
    }
}
