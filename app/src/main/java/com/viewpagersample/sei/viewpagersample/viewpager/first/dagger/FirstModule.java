package com.viewpagersample.sei.viewpagersample.viewpager.first.dagger;

import android.support.v7.widget.LinearLayoutManager;

import com.viewpagersample.sei.viewpagersample.MainActivity;
import com.viewpagersample.sei.viewpagersample.viewpager.first.FirstController;
import com.viewpagersample.sei.viewpagersample.viewpager.first.FirstRecyclerAdapter;
import com.viewpagersample.sei.viewpagersample.viewpager.first.data.FirstData;
import com.viewpagersample.sei.viewpagersample.viewpager.first.viewholder.FirstVHFactory;
import com.viewpagersample.sei.viewpagersample.viewpager.first.viewholder.FirstVHItemFactory;
import com.viewpagersample.sei.viewpagersample.viewpager.first.viewholder.FirstVHItemTwoFactory;

import java.util.Map;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;

/**
 * Created by sei on 7/1/17.
 */

@Module
public class FirstModule {

    private FirstController firstController;

    public FirstModule(FirstController firstController) {
        this.firstController = firstController;
    }

    @Provides
    @FirstScope
    FirstController providesFirstController() {
        return firstController;
    }

    @Provides
    @FirstScope
    LinearLayoutManager providesLinearLayoutManager(MainActivity mainActivity) {
        return new LinearLayoutManager(mainActivity);
    }

    @Provides
    @FirstScope
    FirstRecyclerAdapter providesFirstRecyclerAdapter(FirstController firstController,
                                                      Map<Integer, FirstVHFactory>
                                                              viewHolderFactories) {
        return new FirstRecyclerAdapter(firstController, viewHolderFactories);
    }

    @Provides
    @IntoMap
    @IntKey(FirstData.TYPE_ITEM)
    FirstVHFactory providesFirstVHItem(FirstController firstController) {
        return new FirstVHItemFactory();
    }

    @Provides
    @IntoMap
    @IntKey(FirstData.TYPE_ITEM2)
    FirstVHFactory providesFirstVHItemTwo(FirstController firstController) {
        return new FirstVHItemTwoFactory();
    }
}
