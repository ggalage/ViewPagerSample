package com.viewpagersample.sei.viewpagersample.viewpager.second.dagger;

import com.viewpagersample.sei.viewpagersample.viewpager.dagger.ViewPagerComponent;
import com.viewpagersample.sei.viewpagersample.viewpager.second.SecondController;

import dagger.Component;

/**
 * Created by sei on 7/1/17.
 */

@SecondScope
@Component(dependencies = {ViewPagerComponent.class}, modules = {SecondModule.class})
public interface SecondComponent {
    void inject(SecondController secondController);
}
