package com.wj.myapplication;

import java.io.File;

/**
 * author wangjing
 * Date 2020/2/18
 * Description
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("H:\\Mp3");
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            String namei = files[i].getName().split("\\.")[0];
            for (int a = i + 1; a < files.length; a++) {
                try{

                    String namej = files[a].getName().split("\\.")[0];
                    if(namei.equals(namej)){
                        if(files[i].getName().contains("mp3")){
                            System.out.println(files[i].getName());
                            files[i].delete();
                        }
                        if(files[a].getName().contains("mp3")){
                            System.out.println(files[a].getName());
                            files[a].delete();
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }


            }

        }
    }
}
