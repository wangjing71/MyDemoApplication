package com.wj.myapplication.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.wj.myapplication.R;
import com.wj.myapplication.adapter.HomeViewPagerAdapter;
import com.wj.myapplication.base.BaseActivity;
import com.wj.myapplication.fragment.ActivityFragment;
import com.wj.myapplication.fragment.HomeFragment;
import com.wj.myapplication.fragment.HomePageFragment2;
import com.wj.myapplication.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.tab_menu)
    LinearLayout tabMenu;

    private HomeViewPagerAdapter homeViewPagerAdapter;
    private List<Fragment> fragmentList = new ArrayList<>();
    private int[] defaultIconList =
            new int[]{R.mipmap.home_def, R.mipmap.activity_def, R.mipmap.message_def, R.mipmap.mine_def};
    private int[] focusIconList =
            new int[]{R.mipmap.home_foc, R.mipmap.activity_foc, R.mipmap.message_foc, R.mipmap.mine_foc};
    private String[] titleList =
            new String[]{"首页", "活动", "消息", "我的"};

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initData() {
        initTabMenu();
        initFragment();

        fragmentList.add(new HomeFragment());
        fragmentList.add(new ActivityFragment());
        fragmentList.add(new HomePageFragment2());
        fragmentList.add(new MineFragment());


        homeViewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        vpMain.setAdapter(homeViewPagerAdapter);
        vpMain.setOffscreenPageLimit(4);
    }

    private void initTabMenu() {
        for (int i = 0; i < 4; i++) {
            View items = LayoutInflater.from(this).inflate(R.layout.tab_menu_item, null, false);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1;
            items.setLayoutParams(params);
            ImageView focused_icon = items.findViewById(R.id.focused_icon);
            ImageView default_icon = items.findViewById(R.id.default_icon);
            TextView focused_title = items.findViewById(R.id.focused_title);
            TextView default_title = items.findViewById(R.id.default_title);
            focused_title.setText(titleList[i]);
            default_title.setText(titleList[i]);
            Glide.with(this).load(focusIconList[i]).into(focused_icon);
            Glide.with(this).load(defaultIconList[i]).into(default_icon);
            tabMenu.addView(items);

            final int finalI = i;
            items.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    initBottonSelectIndex(finalI);
                }
            });
            initBottonSelectIndex(0);
        }
    }

    private void initFragment() {
    }


    @Override
    protected void setEvent() {
        vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                initBottonSelectIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initBottonSelectIndex(int index) {
        vpMain.setCurrentItem(index, false);
        int count = tabMenu.getChildCount();
        for (int i = 0; i < count; i++) {
            View itemsParents = tabMenu.getChildAt(i);
            if (i == index) {
                itemsParents.findViewById(R.id.focused_parent).setVisibility(View.VISIBLE);
                itemsParents.findViewById(R.id.default_parent).setVisibility(View.GONE);
            } else {
                itemsParents.findViewById(R.id.focused_parent).setVisibility(View.GONE);
                itemsParents.findViewById(R.id.default_parent).setVisibility(View.VISIBLE);
            }
        }
    }
}
