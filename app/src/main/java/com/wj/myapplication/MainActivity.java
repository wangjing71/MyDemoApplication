package com.wj.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity {

    private Button button;

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
    }

    private void doSomeThing() {
        installShortCut("我是创建的快捷方式",R.mipmap.ic_launcher,new Intent(this,Main2Activity.class));
    }

    /**
     * 创建快捷方式
     *
     * @param name
     * @param icon
     * @param intent
     */
    public void installShortCut(String name, int icon, Intent intent) {
        Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");

        // 快捷方式的名称
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, name);
        shortcut.putExtra("duplicate", false); // 不允许重复创建

        // 快捷方式的图标
        Intent.ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(this, icon);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);

        intent.setAction("android.intent.action.MAIN");// 桌面图标和应用绑定，卸载应用后系统会同时自动删除图标
        intent.addCategory("android.intent.category.LAUNCHER");// 桌面图标和应用绑定，卸载应用后系统会同时自动删除图标
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);
        sendBroadcast(shortcut);
    }

    /**
     * 删除桌面快捷方式
     * @param context
     * @param shortcutName
     * 快捷方式名
     * @param actionIntent
     * 快捷方式操作，也就是上面创建的Intent
     * @param isDuplicate
     * 为true时循环删除快捷方式（即存在很多相同的快捷方式）
     */
    public static void deleteShortcut(Context context , String shortcutName ,
                                      Intent actionIntent , boolean isDuplicate) {
        Intent shortcutIntent = new Intent ("com.android.launcher.action.UNINSTALL_SHORTCUT");
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME ,shortcutName);
        shortcutIntent.putExtra("duplicate" , isDuplicate);
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT , actionIntent);
        context.sendBroadcast(shortcutIntent);
    }
}
