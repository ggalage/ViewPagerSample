package com.viewpagersample.sei.viewpagersample.viewpager.second.dagger;

import android.support.v7.widget.LinearLayoutManager;

import com.viewpagersample.sei.viewpagersample.MainActivity;
import com.viewpagersample.sei.viewpagersample.viewpager.first.dagger.FirstScope;
import com.viewpagersample.sei.viewpagersample.viewpager.second.SecondController;
import com.viewpagersample.sei.viewpagersample.viewpager.second.SecondRecyclerAdapter;
import com.viewpagersample.sei.viewpagersample.viewpager.second.data.SecondData;
import com.viewpagersample.sei.viewpagersample.viewpager.second.viewholder.SecondVHFactory;
import com.viewpagersample.sei.viewpagersample.viewpager.second.viewholder.SecondVHItemFactory;
import com.viewpagersample.sei.viewpagersample.viewpager.second.viewholder.SecondVHItemTwoFactory;

import java.util.Map;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;

/**
 * Created by sei on 7/1/17.
 */

@Module
public class SecondModule {

    private SecondController secondController;

    public SecondModule(SecondController secondController) {
        this.secondController = secondController;
    }

    @Provides
    @SecondScope
    SecondController providesSecondController() {
        return secondController;
    }

    @Provides
    @SecondScope
    SecondRecyclerAdapter providesSecondRecyclerAdapter(SecondController secondController,
                                                      Map<Integer, SecondVHFactory>
                                                              viewHolderFactories) {
        return new SecondRecyclerAdapter(secondController, viewHolderFactories);
    }

    @Provides
    @SecondScope
    LinearLayoutManager providesLinearLayoutManager(MainActivity mainActivity) {
        return new LinearLayoutManager(mainActivity);
    }


    @Provides
    @IntoMap
    @IntKey(SecondData.TYPE_ITEM)
    SecondVHFactory providesSecondVHItem(SecondController secondController) {
        return new SecondVHItemFactory();
    }

    @Provides
    @IntoMap
    @IntKey(SecondData.TYPE_ITEM2)
    SecondVHFactory providesSecondVHItemTwo(SecondController secondController) {
        return new SecondVHItemTwoFactory();
    }
}
