package com.viewpagersample.sei.viewpagersample.viewpager.third;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.viewpagersample.sei.viewpagersample.viewpager.third.data.ThirdData;

import java.util.List;

/**
 * Created by sei on 7/1/17.
 */

public interface ThirdView extends MvpView {

    void showLoadingView();

    void showContentView();

    void showErrorView();

    void setDataToController(List<ThirdData> data);
}
