package com.viewpagersample.sei.viewpagersample.viewpager.first;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.viewpagersample.sei.viewpagersample.viewpager.first.data.FirstData;

import java.util.List;

/**
 * Created by sei on 7/1/17.
 */

public interface FirstView extends MvpView {

    void showLoadingView();

    void showContentView();

    void showErrorView();

    void setDataToController(List<FirstData> data);
}
