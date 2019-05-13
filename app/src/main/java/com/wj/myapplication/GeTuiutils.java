package com.wj.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

/**
 * author wangjing
 * Date 2019/5/13
 * Description
 */
public class GeTuiutils {
    public static void sendMessage(Context context,String message){
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
		Intent intent = new Intent();
		intent.setAction("getui_message");
		intent.putExtra("message",message);
        localBroadcastManager.sendBroadcast(intent);
    }
}
