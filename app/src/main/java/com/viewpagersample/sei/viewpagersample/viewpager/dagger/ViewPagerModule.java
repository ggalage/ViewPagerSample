package com.viewpagersample.sei.viewpagersample.viewpager.dagger;

import com.viewpagersample.sei.viewpagersample.viewpager.ViewPagerController;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sei on 7/1/17.
 */

@Module
public class ViewPagerModule {

    private ViewPagerController viewPagerController;

    public ViewPagerModule(ViewPagerController viewPagerController) {
        this.viewPagerController = viewPagerController;
    }

    @Provides
    @ViewPagerScope
    ViewPagerController providesViewPagerController() {
        return viewPagerController;
    }
}
