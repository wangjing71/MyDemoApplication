package com.wj.myapplication;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * author wangjing
 * Date 2020/7/2
 * Description
 */
public class Mp4ToBase4Util {
    /**
     * @param videofilePath 视频文件路径带文件名
     * @return base64
     */
    public static String videoToBase64(File videofilePath) {
        long size = videofilePath.length();
        byte[] imageByte = new byte[(int) size];
        FileInputStream fs = null;
        BufferedInputStream bis = null;
        try {
            fs = new FileInputStream(videofilePath);
            bis = new BufferedInputStream(fs);
            bis.read(imageByte);
        } catch (FileNotFoundException e) {
            Log.i("文件" + videofilePath.getName() + "不能被找到：{}", e.getMessage());
        } catch (IOException e) {
            Log.i("====", "byte转换BASE64出错：" + e.getMessage());
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    Log.i("====", "关闭输入流出错：" + e.getMessage());
                }
            }
            if (fs != null) {
                try {
                    fs.close();
                } catch (IOException e) {
                    Log.i("====", "关闭输入流出错：" + e.getMessage());
                }
            }
        }
        return Base64.encodeToString(imageByte, Base64.DEFAULT);
    }

    private String fileBase64String(Context context, Uri url) {
        try {
            InputStream fis = context.getContentResolver().openInputStream(url);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = fis.read(buffer)) >= 0) {
                baos.write(buffer, 0, count);//读取输入流并写入输出字节流中
            }
            fis.close();//关闭文件输入流
            return Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
        } catch (Exception e) {
            Log.e("====", "错误--> " + e);
            return null;
        }
    }
}


