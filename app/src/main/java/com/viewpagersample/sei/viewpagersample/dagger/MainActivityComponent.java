package com.viewpagersample.sei.viewpagersample.dagger;

import com.viewpagersample.sei.viewpagersample.MainActivity;

import dagger.Component;

/**
 * Created by sei on 7/1/17.
 */

@MainActivityScope
@Component(modules = {MainActivityModule.class})
public interface MainActivityComponent {
    MainActivity mainActivity();
}
