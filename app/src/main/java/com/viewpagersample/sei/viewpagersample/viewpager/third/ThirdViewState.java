package com.viewpagersample.sei.viewpagersample.viewpager.third;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.hannesdorfmann.mosby3.mvp.viewstate.RestorableViewState;
import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;
import com.viewpagersample.sei.viewpagersample.viewpager.third.data.ThirdData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sei on 7/1/17.
 */

public class ThirdViewState implements RestorableViewState<ThirdView> {

    private final String KEY_STATE = "ThirdVS-State";
    private final String KEY_DATA = "ThirdVS-Data";
    private final String SNAPPY_KEY = "ThirdSNAPPY-Data";
    private final String SNAPPY_LOG = "ThirdSNAPPY-Error";

    private int currentViewState;
    private final int STATE_SHOW_LOADING = 0;
    private final int STATE_SHOW_CONTENT = 1;
    private final int STATE_SHOW_ERROR = 2;

    private ThirdController thirdController;

    private List<ThirdData> thirdDataList;

    public ThirdViewState(ThirdController thirdController) {
        this.thirdController = thirdController;
    }

    @Override
    public void saveInstanceState(@NonNull Bundle out) {
        out.putInt(KEY_STATE, currentViewState);
        try {
            DB snappydb = DBFactory.open(thirdController.getActivity(), KEY_DATA);
            if (thirdDataList != null) {
                ThirdData[] inputArray = thirdDataList.toArray(new ThirdData[0]);
                snappydb.put(SNAPPY_KEY, inputArray);
            }
            snappydb.close();
        } catch (SnappydbException e) {
            Log.e(SNAPPY_LOG, "write: " + e);
        }
    }

    @Override
    public RestorableViewState<ThirdView> restoreInstanceState(Bundle in) {
        if (in == null) {
            return null;
        }
        currentViewState = in.getInt(KEY_STATE, 0);
        try {
            DB snappydb = DBFactory.open(thirdController.getActivity(), KEY_DATA);
            ThirdData[] returnedArray = snappydb.getObjectArray(SNAPPY_KEY, ThirdData.class);
            snappydb.close();
            thirdDataList = new ArrayList<>(Arrays.asList(returnedArray));
        } catch (SnappydbException e) {
            Log.e(SNAPPY_LOG, "read: " + e);
        }
        return this;
    }

    @Override
    public void apply(ThirdView view, boolean retained) {
        switch (currentViewState) {
            case STATE_SHOW_LOADING:
                view.showLoadingView();
                break;
            case STATE_SHOW_CONTENT:
                view.setDataToController(thirdDataList);
                view.showContentView();
                break;
            case STATE_SHOW_ERROR:
                view.showErrorView();
                break;
        }
    }
    public void setShowingLoading() {
        this.currentViewState = STATE_SHOW_LOADING;
    }
    public void setShowingContent() {
        this.currentViewState = STATE_SHOW_CONTENT;
    }
    public void setShowingError() {
        this.currentViewState = STATE_SHOW_ERROR;
    }
    public void setDataToViewState(List<ThirdData> thirdDataList) {
        this.thirdDataList = thirdDataList;
    }

}
