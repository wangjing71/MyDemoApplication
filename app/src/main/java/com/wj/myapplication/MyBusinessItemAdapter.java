package com.wj.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * author wangjing
 * Date 2019/10/28
 * Description
 */
public class MyBusinessItemAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragList;

    public MyBusinessItemAdapter(FragmentManager fm, ArrayList<Fragment> fragList) {
        super(fm);
        this.fragList = fragList;
    }

    public MyBusinessItemAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragList.get(position);
    }

    @Override
    public int getCount() {
        return fragList.size();
    }
}
