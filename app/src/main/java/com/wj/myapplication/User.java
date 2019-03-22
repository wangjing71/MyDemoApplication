package com.wj.myapplication;

/**
 * author wangjing
 * Date 2019/3/22
 * Description
 */
public class User {


    private String UserName;
    private String UserSex;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserSex() {
        return UserSex;
    }

    public void setUserSex(String userSex) {
        UserSex = userSex;
    }

    public User(String userName, String userSex) {
        UserName = userName;
        UserSex = userSex;
    }

}
