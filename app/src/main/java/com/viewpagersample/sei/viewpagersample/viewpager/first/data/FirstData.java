package com.viewpagersample.sei.viewpagersample.viewpager.first.data;

/**
 * Created by sei on 7/1/17.
 */

public class FirstData {

    public static final int TYPE_ITEM = 1;
    public static final int TYPE_ITEM2 = 2;

    public int type;
    public String text;

    public FirstData() {
    }

    public FirstData(int type) {
        this.type = type;
    }

    public FirstData(int type, String text) {
        this.type = type;
        this.text = text;
    }

}
