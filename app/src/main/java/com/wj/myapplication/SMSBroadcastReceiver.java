package com.wj.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

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

            Log.i(TAG, "onReceive: 短信来自:" + sender);
            Log.i(TAG, "onReceive: 短信内容:" + content);
            Log.i(TAG, "onReceive: 短信时间:" + time);

            //如果短信号码来自自己的短信网关号码
            if ("your sender number".equals(sender) && mMessageListener != null) {
                Log.i(TAG, "onReceive: 回调");
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

