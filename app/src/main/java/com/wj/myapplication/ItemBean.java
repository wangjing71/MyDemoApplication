package com.wj.myapplication;

/**
 * author wangjing
 * Date 2019/10/14
 * Description
 */
public class ItemBean {
    private int type;
    private String dat;

    public ItemBean(int type, String dat) {
        this.type = type;
        this.dat = dat;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDat() {
        return dat;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }
}
