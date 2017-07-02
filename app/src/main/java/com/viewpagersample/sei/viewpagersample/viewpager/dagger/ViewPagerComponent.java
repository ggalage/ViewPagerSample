package com.viewpagersample.sei.viewpagersample.viewpager.dagger;

import com.viewpagersample.sei.viewpagersample.MainActivity;
import com.viewpagersample.sei.viewpagersample.dagger.MainActivityComponent;
import com.viewpagersample.sei.viewpagersample.viewpager.ViewPagerController;

import dagger.Component;

/**
 * Created by sei on 7/1/17.
 */

@ViewPagerScope
@Component(dependencies = {MainActivityComponent.class}, modules = {ViewPagerModule.class})
public interface ViewPagerComponent {
    MainActivity mainActivity();
    ViewPagerController viewPagerController();
}
