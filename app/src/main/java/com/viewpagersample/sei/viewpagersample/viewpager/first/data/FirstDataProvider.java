package com.viewpagersample.sei.viewpagersample.viewpager.first.data;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sei on 7/1/17.
 */

public class FirstDataProvider {

    public static ArrayList<FirstData> provideData() {
        return new ArrayList<>(Arrays.asList(
                new FirstData(FirstData.TYPE_ITEM),
                new FirstData(FirstData.TYPE_ITEM2),
                new FirstData(FirstData.TYPE_ITEM),
                new FirstData(FirstData.TYPE_ITEM2),
                new FirstData(FirstData.TYPE_ITEM),
                new FirstData(FirstData.TYPE_ITEM2),
                new FirstData(FirstData.TYPE_ITEM),
                new FirstData(FirstData.TYPE_ITEM2),
                new FirstData(FirstData.TYPE_ITEM),
                new FirstData(FirstData.TYPE_ITEM2),
                new FirstData(FirstData.TYPE_ITEM),
                new FirstData(FirstData.TYPE_ITEM2),
                new FirstData(FirstData.TYPE_ITEM),
                new FirstData(FirstData.TYPE_ITEM2),
                new FirstData(FirstData.TYPE_ITEM),
                new FirstData(FirstData.TYPE_ITEM2),
                new FirstData(FirstData.TYPE_ITEM),
                new FirstData(FirstData.TYPE_ITEM2),
                new FirstData(FirstData.TYPE_ITEM),
                new FirstData(FirstData.TYPE_ITEM2),
                new FirstData(FirstData.TYPE_ITEM),
                new FirstData(FirstData.TYPE_ITEM2)
        ));
    }

    public static ArrayList<FirstData> provideUpdateData() {
        return new ArrayList<>(Arrays.asList(
                new FirstData(FirstData.TYPE_ITEM, "First Tab updated"),
                new FirstData(FirstData.TYPE_ITEM2, "1st Tab updated"),
                new FirstData(FirstData.TYPE_ITEM, "First Tab updated"),
                new FirstData(FirstData.TYPE_ITEM2, "1st Tab updated"),
                new FirstData(FirstData.TYPE_ITEM, "First Tab updated"),
                new FirstData(FirstData.TYPE_ITEM2, "1st Tab updated"),
                new FirstData(FirstData.TYPE_ITEM, "First Tab updated"),
                new FirstData(FirstData.TYPE_ITEM2, "1st Tab updated"),
                new FirstData(FirstData.TYPE_ITEM, "First Tab updated"),
                new FirstData(FirstData.TYPE_ITEM2, "1st Tab updated"),
                new FirstData(FirstData.TYPE_ITEM, "First Tab updated"),
                new FirstData(FirstData.TYPE_ITEM2, "1st Tab updated"),
                new FirstData(FirstData.TYPE_ITEM, "First Tab updated"),
                new FirstData(FirstData.TYPE_ITEM2, "1st Tab updated"),
                new FirstData(FirstData.TYPE_ITEM, "First Tab updated"),
                new FirstData(FirstData.TYPE_ITEM2, "1st Tab updated"),
                new FirstData(FirstData.TYPE_ITEM, "First Tab updated"),
                new FirstData(FirstData.TYPE_ITEM2, "1st Tab updated"),
                new FirstData(FirstData.TYPE_ITEM, "First Tab updated"),
                new FirstData(FirstData.TYPE_ITEM2, "1st Tab updated"),
                new FirstData(FirstData.TYPE_ITEM, "First Tab updated"),
                new FirstData(FirstData.TYPE_ITEM2, "1st Tab updated"),
                new FirstData(FirstData.TYPE_ITEM, "First Tab updated"),
                new FirstData(FirstData.TYPE_ITEM2, "1st Tab updated"),
                new FirstData(FirstData.TYPE_ITEM, "First Tab updated"),
                new FirstData(FirstData.TYPE_ITEM2, "1st Tab updated"),
                new FirstData(FirstData.TYPE_ITEM, "First Tab updated"),
                new FirstData(FirstData.TYPE_ITEM2, "1st Tab updated")
        ));
    }
}
