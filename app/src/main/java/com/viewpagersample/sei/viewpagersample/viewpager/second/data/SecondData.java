package com.viewpagersample.sei.viewpagersample.viewpager.second.data;

/**
 * Created by sei on 7/1/17.
 */

public class SecondData {
    public static final int TYPE_ITEM = 1;
    public static final int TYPE_ITEM2 = 2;

    public int type;
    public String text;

    public SecondData() {
    }

    public SecondData(int type) {
        this.type = type;
    }

    public SecondData(int type, String text) {
        this.type = type;
        this.text = text;
    }
}
