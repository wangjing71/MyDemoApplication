package com.wj.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    private Button button;
    private Button button1;
    private Button button2;
    private NotificationManager manager;
    NotificationCompat.Builder builder = null;
    private Notification notification;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSomeThing();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                builder.setProgress(100, count, false);
                builder.setContentText("下载进度:" + count + "%");
                notification = builder.build();
                manager.notify(1, notification);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setContentTitle("下载完成")
                        .setContentText("点击安装")
                        .setAutoCancel(true);//设置通知被点击一次是否自动取消
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.setDataAndType(Uri.parse("file://" + file.toString()), "application/vnd.android.package-archive");
//                PendingIntent pi = PendingIntent.getActivity(context, 0, intent, 0);
//                notification = builder.setContentIntent(pi).build();
                notification = builder.build();
                manager.notify(1, notification);
            }
        });

    }

    private void doSomeThing() {
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String channelId = "message";
            NotificationChannel channel = new NotificationChannel(channelId, "消息", NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
            builder = new NotificationCompat.Builder(this,channelId);
        }else{
            builder = new NotificationCompat.Builder(this);
        }
        builder.setContentTitle("正在更新...")
                .setContentText("地铁沿线30万商铺抢购中！地铁沿线30万商铺抢购中！地铁")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(new NotificationCompat.BigTextStyle())
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setDefaults(Notification.DEFAULT_LIGHTS) //设置通知的提醒方式： 呼吸灯
                .setPriority(NotificationCompat.PRIORITY_MAX) //设置通知的优先级：最大
                .setAutoCancel(false);//设置通知被点击一次是否自动取消
//                .setContentText("下载进度:" + "0%")
//                .setProgress(100, 0, false);
        notification = builder.build();
        //发送通知
        manager.notify(1, notification);
    }
}
