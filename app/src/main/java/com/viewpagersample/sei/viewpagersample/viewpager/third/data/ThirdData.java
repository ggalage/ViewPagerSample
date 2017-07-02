package com.viewpagersample.sei.viewpagersample.viewpager.third.data;

/**
 * Created by sei on 7/1/17.
 */

public class ThirdData {

    public static final int TYPE_ITEM = 1;
    public static final int TYPE_ITEM2 = 2;

    public int type;
    public String text;

    public ThirdData() {
    }

    public ThirdData(int type) {
        this.type = type;
    }

    public ThirdData(int type, String text) {
        this.type = type;
        this.text = text;
    }

}
