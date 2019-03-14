package com.wj.myapplication;

import android.content.Context;
import android.util.AttributeSet;

import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

/**
 * author wangjing
 * Date 2019/3/14
 * Description
 */
public class MyVideoView extends StandardGSYVideoPlayer {
    public MyVideoView(Context context, Boolean fullFlag) {
        super(context, fullFlag);
    }

    public MyVideoView(Context context) {
        super(context);
    }

    public MyVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int getLayoutId() {
        return R.layout.myvideo;
    }
}
