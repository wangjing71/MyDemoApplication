package com.wj.myapplication;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.telephony.SmsMessage;
import android.util.Log;

import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.reactivex.functions.Consumer;

/**
 * author wangjing
 * Date 2019/2/25
 * Description
 */
public class SMSBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "SMSBroadcastReceiver";

    private static MessageListener mMessageListener;

    public SMSBroadcastReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Object[] pdus = (Object[]) intent.getExtras().get("pdus");
        for (Object pdu : pdus) {
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);
            String sender = smsMessage.getDisplayOriginatingAddress();
            String content = smsMessage.getMessageBody();
            long date = smsMessage.getTimestampMillis();
            Date timeDate = new Date(date);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = simpleDateFormat.format(timeDate);

            Log.i(TAG, "onReceive:  来自:" + sender);
            Log.i(TAG, "onReceive: 短信内容:" + content);
            Log.i(TAG, "onReceive: 短信时间:" + time);

            if(mMessageListener!=null){
                mMessageListener.OnReceived(content);
            }
        }
    }

    // 回调接口
    public interface MessageListener {

        /**
         * 接收到自己的验证码时回调
         * @param message 短信内容
         */
        void OnReceived(String message);
    }

    /**
     * 设置验证码接收监听
     * @param messageListener 自己验证码的接受监听，接收到自己验证码时回调
     */
    public void setOnReceivedMessageListener(MessageListener messageListener) {
        this.mMessageListener = messageListener;
    }
}

