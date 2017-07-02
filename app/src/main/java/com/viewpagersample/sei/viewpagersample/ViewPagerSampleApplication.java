package com.viewpagersample.sei.viewpagersample;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by sei on 7/1/17.
 */

public class ViewPagerSampleApplication extends Application {

    public static RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);

    }
}
