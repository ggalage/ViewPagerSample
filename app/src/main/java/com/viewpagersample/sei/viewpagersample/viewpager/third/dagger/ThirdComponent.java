package com.viewpagersample.sei.viewpagersample.viewpager.third.dagger;

import com.viewpagersample.sei.viewpagersample.viewpager.dagger.ViewPagerComponent;
import com.viewpagersample.sei.viewpagersample.viewpager.third.ThirdController;

import dagger.Component;

/**
 * Created by sei on 7/1/17.
 */

@ThirdScope
@Component(dependencies = {ViewPagerComponent.class}, modules = {ThirdModule.class})
public interface ThirdComponent {
    void inject(ThirdController thirdController);
}
