package com.baidu.aip.asrwakeup3.core.recog.listener;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.aip.asrwakeup3.core.recog.RecogResult;
import com.baidu.speech.asr.SpeechConstant;

/**
 * Created by fujiayi on 2017/6/16.
 */

public class MessageStatusRecogListener extends StatusRecogListener {
    public static final int READY_SPEAK = 0; //引擎就绪，可以开始说话
    public static final int BEGIN_SPEAK = 1; //检测到用户说话
    public static final int PARTIAL_SPEAK = 2;//临时识别结果
    public static final int FINAL_SPEAK = 3;//临时识别结果
    public static final int STOP_SPEAK = 4;////检测到用户说话结束
    public static final int ERROR_SPEAK = 5;////检测到错误
    private Handler handler;
    private long speechEndTime = 0;
    private boolean needTime = true;
    private static final String TAG = "MesStatusRecogListener";

    public MessageStatusRecogListener(Handler handler) {
        this.handler = handler;
    }


    @Override
    public void onAsrReady() {
        super.onAsrReady();
        speechEndTime = 0;

        Message message = Message.obtain();
        message.what = READY_SPEAK;
        handler.sendMessage(message);
    }

    @Override
    public void onAsrBegin() {
        super.onAsrBegin();
        Message message = Message.obtain();
        message.what = BEGIN_SPEAK;
        handler.sendMessage(message);
    }

    @Override
    public void onAsrEnd() {
        super.onAsrEnd();
        speechEndTime = System.currentTimeMillis();
        Message message = Message.obtain();
        message.what = STOP_SPEAK;
        handler.sendMessage(message);
    }

    @Override
    public void onAsrPartialResult(String[] results, RecogResult recogResult) {
        super.onAsrPartialResult(results, recogResult);
        Message message = Message.obtain();
        message.what = PARTIAL_SPEAK;
        message.obj = results[0];
        handler.sendMessage(message);
    }

    @Override
    public void onAsrFinalResult(String[] results, RecogResult recogResult) {
        super.onAsrFinalResult(results, recogResult);
        Message message = Message.obtain();
        message.what = FINAL_SPEAK;
        message.obj = results[0];
        handler.sendMessage(message);

    }

    @Override
    public void onAsrFinishError(int errorCode, int subErrorCode, String descMessage,
                                 RecogResult recogResult) {
        super.onAsrFinishError(errorCode, subErrorCode, descMessage, recogResult);
        Message message = Message.obtain();
        message.what = ERROR_SPEAK;
        handler.sendMessage(message);
    }

    @Override
    public void onAsrOnlineNluResult(String nluResult) {
        super.onAsrOnlineNluResult(nluResult);
    }

    @Override
    public void onAsrFinish(RecogResult recogResult) {
        super.onAsrFinish(recogResult);
    }

    /**
     * 长语音识别结束
     */
    @Override
    public void onAsrLongFinish() {
        super.onAsrLongFinish();
    }


    /**
     * 使用离线命令词时，有该回调说明离线语法资源加载成功
     */
    @Override
    public void onOfflineLoaded() {
    }

    /**
     * 使用离线命令词时，有该回调说明离线语法资源加载成功
     */
    @Override
    public void onOfflineUnLoaded() {
    }

    @Override
    public void onAsrExit() {
        super.onAsrExit();
    }

}
