package com.viewpagersample.sei.viewpagersample.viewpager.first.dagger;

import com.viewpagersample.sei.viewpagersample.viewpager.dagger.ViewPagerComponent;
import com.viewpagersample.sei.viewpagersample.viewpager.first.FirstController;

import dagger.Component;

/**
 * Created by sei on 7/1/17.
 */

@FirstScope
@Component(dependencies = {ViewPagerComponent.class}, modules = {FirstModule.class})
public interface FirstComponent {
    void inject(FirstController firstController);
}
