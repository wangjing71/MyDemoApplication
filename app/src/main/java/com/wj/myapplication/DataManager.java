package com.wj.myapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gyq on 2017/9/8 10:02
 */
public class DataManager {
    private static List<String> sStringList = Arrays.asList("电视剧", "电影", "音乐", "王者荣耀",
            "那年花开", "综艺", "体育", "少儿", "动漫");

    public static final List<String> getData(int number) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            stringList.add(sStringList.get(i % sStringList.size()));
        }
        return stringList;
    }
}

