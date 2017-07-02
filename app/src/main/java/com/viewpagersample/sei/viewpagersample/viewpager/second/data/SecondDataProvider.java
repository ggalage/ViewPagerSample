package com.viewpagersample.sei.viewpagersample.viewpager.second.data;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sei on 7/1/17.
 */

public class SecondDataProvider {

    public static ArrayList<SecondData> provideData() {
        return new ArrayList<>(Arrays.asList(
                new SecondData(SecondData.TYPE_ITEM),
                new SecondData(SecondData.TYPE_ITEM2),
                new SecondData(SecondData.TYPE_ITEM),
                new SecondData(SecondData.TYPE_ITEM2),
                new SecondData(SecondData.TYPE_ITEM),
                new SecondData(SecondData.TYPE_ITEM2),
                new SecondData(SecondData.TYPE_ITEM),
                new SecondData(SecondData.TYPE_ITEM2),
                new SecondData(SecondData.TYPE_ITEM),
                new SecondData(SecondData.TYPE_ITEM2),
                new SecondData(SecondData.TYPE_ITEM),
                new SecondData(SecondData.TYPE_ITEM2),
                new SecondData(SecondData.TYPE_ITEM),
                new SecondData(SecondData.TYPE_ITEM2),
                new SecondData(SecondData.TYPE_ITEM),
                new SecondData(SecondData.TYPE_ITEM2),
                new SecondData(SecondData.TYPE_ITEM),
                new SecondData(SecondData.TYPE_ITEM2),
                new SecondData(SecondData.TYPE_ITEM),
                new SecondData(SecondData.TYPE_ITEM2),
                new SecondData(SecondData.TYPE_ITEM),
                new SecondData(SecondData.TYPE_ITEM2)
        ));
    }

    public static ArrayList<SecondData> provideUpdateData() {
        return new ArrayList<>(Arrays.asList(
                new SecondData(SecondData.TYPE_ITEM, "Second Tab updated"),
                new SecondData(SecondData.TYPE_ITEM2, "2nd Tab updated"),
                new SecondData(SecondData.TYPE_ITEM, "Second Tab updated"),
                new SecondData(SecondData.TYPE_ITEM2, "2nd Tab updated"),
                new SecondData(SecondData.TYPE_ITEM, "Second Tab updated"),
                new SecondData(SecondData.TYPE_ITEM2, "2nd Tab updated"),
                new SecondData(SecondData.TYPE_ITEM, "Second Tab updated"),
                new SecondData(SecondData.TYPE_ITEM2, "2nd Tab updated"),
                new SecondData(SecondData.TYPE_ITEM, "Second Tab updated"),
                new SecondData(SecondData.TYPE_ITEM2, "2nd Tab updated"),
                new SecondData(SecondData.TYPE_ITEM, "Second Tab updated"),
                new SecondData(SecondData.TYPE_ITEM2, "2nd Tab updated"),
                new SecondData(SecondData.TYPE_ITEM, "Second Tab updated"),
                new SecondData(SecondData.TYPE_ITEM2, "2nd Tab updated"),
                new SecondData(SecondData.TYPE_ITEM, "Second Tab updated"),
                new SecondData(SecondData.TYPE_ITEM2, "2nd Tab updated"),
                new SecondData(SecondData.TYPE_ITEM, "Second Tab updated"),
                new SecondData(SecondData.TYPE_ITEM2, "2nd Tab updated"),
                new SecondData(SecondData.TYPE_ITEM, "Second Tab updated"),
                new SecondData(SecondData.TYPE_ITEM2, "2nd Tab updated"),
                new SecondData(SecondData.TYPE_ITEM, "Second Tab updated"),
                new SecondData(SecondData.TYPE_ITEM2, "2nd Tab updated"),
                new SecondData(SecondData.TYPE_ITEM, "Second Tab updated"),
                new SecondData(SecondData.TYPE_ITEM2, "2nd Tab updated"),
                new SecondData(SecondData.TYPE_ITEM, "Second Tab updated"),
                new SecondData(SecondData.TYPE_ITEM2, "2nd Tab updated"),
                new SecondData(SecondData.TYPE_ITEM, "Second Tab updated"),
                new SecondData(SecondData.TYPE_ITEM2, "2nd Tab updated")
        ));
    }
}
