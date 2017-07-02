package com.viewpagersample.sei.viewpagersample.viewpager;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

/**
 * Created by sei on 7/1/17.
 */

public class ViewPagerPresenter extends MvpBasePresenter<ViewPagerView> {

    public void showFirst() {
        if (isViewAttached()) {
            getView().showFirst();
        }
    }

    public void showSecond() {
        if (isViewAttached()) {
            getView().showSecond();
        }
    }

    public void showThird() {
        if (isViewAttached()) {
            getView().showThird();
        }
    }
}
