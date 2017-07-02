package com.viewpagersample.sei.viewpagersample.utils;


import android.os.Bundle;
import android.support.annotation.NonNull;

import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.ControllerChangeType;
import com.viewpagersample.sei.viewpagersample.ViewPagerSampleApplication;

/**
 * Created by sei on 7/1/17.
 */

public abstract class RefWatcherController extends ButterknifeController {

    protected RefWatcherController() { }
    protected RefWatcherController(Bundle args) {
        super(args);
    }

    private boolean hasExited;

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (hasExited) {
            ViewPagerSampleApplication.refWatcher.watch(this);
        }
    }

    @Override
    protected void onChangeEnded(@NonNull ControllerChangeHandler changeHandler, @NonNull ControllerChangeType changeType) {
        super.onChangeEnded(changeHandler, changeType);

        hasExited = !changeType.isEnter;
        if (isDestroyed()) {
            ViewPagerSampleApplication.refWatcher.watch(this);
        }
    }
}
