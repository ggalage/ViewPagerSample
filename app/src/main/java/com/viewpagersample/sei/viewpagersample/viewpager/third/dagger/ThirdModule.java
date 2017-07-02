package com.viewpagersample.sei.viewpagersample.viewpager.third.dagger;

import android.support.v7.widget.LinearLayoutManager;

import com.viewpagersample.sei.viewpagersample.MainActivity;
import com.viewpagersample.sei.viewpagersample.viewpager.first.dagger.FirstScope;
import com.viewpagersample.sei.viewpagersample.viewpager.third.ThirdController;
import com.viewpagersample.sei.viewpagersample.viewpager.third.ThirdRecyclerAdapter;
import com.viewpagersample.sei.viewpagersample.viewpager.third.data.ThirdData;
import com.viewpagersample.sei.viewpagersample.viewpager.third.viewholder.ThirdVHFactory;
import com.viewpagersample.sei.viewpagersample.viewpager.third.viewholder.ThirdVHItemFactory;
import com.viewpagersample.sei.viewpagersample.viewpager.third.viewholder.ThirdVHItemTwoFactory;

import java.util.Map;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;

/**
 * Created by sei on 7/1/17.
 */

@Module
public class ThirdModule {

    private ThirdController thirdController;

    public ThirdModule(ThirdController thirdController) {
        this.thirdController = thirdController;
    }

    @Provides
    @ThirdScope
    ThirdController providesThirdController() {
        return thirdController;
    }

    @Provides
    @ThirdScope
    ThirdRecyclerAdapter providesThirdRecyclerAdapter(ThirdController thirdController,
                                                      Map<Integer, ThirdVHFactory>
                                                              viewHolderFactories) {
        return new ThirdRecyclerAdapter(thirdController, viewHolderFactories);
    }

    @Provides
    @ThirdScope
    LinearLayoutManager providesLinearLayoutManager(MainActivity mainActivity) {
        return new LinearLayoutManager(mainActivity);
    }


    @Provides
    @IntoMap
    @IntKey(ThirdData.TYPE_ITEM)
    ThirdVHFactory providesThirdVHItem(ThirdController thirdController) {
        return new ThirdVHItemFactory();
    }

    @Provides
    @IntoMap
    @IntKey(ThirdData.TYPE_ITEM2)
    ThirdVHFactory providesThirdVHItemTwo(ThirdController thirdController) {
        return new ThirdVHItemTwoFactory();
    }
}
