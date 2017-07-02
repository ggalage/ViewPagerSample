package com.viewpagersample.sei.viewpagersample.viewpager.second;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.viewpagersample.sei.viewpagersample.viewpager.second.data.SecondData;

import java.util.List;

/**
 * Created by sei on 7/1/17.
 */

public interface SecondView extends MvpView{

    void showLoadingView();

    void showContentView();

    void showErrorView();

    void setDataToController(List<SecondData> data);
}
