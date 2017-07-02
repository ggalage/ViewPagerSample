package com.viewpagersample.sei.viewpagersample.dagger;

import android.support.design.widget.TabLayout;

import com.viewpagersample.sei.viewpagersample.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sei on 7/1/17.
 */

@Module
public class MainActivityModule {

    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainActivityScope
    MainActivity providesMainActivity() {
        return mainActivity;
    }
}
