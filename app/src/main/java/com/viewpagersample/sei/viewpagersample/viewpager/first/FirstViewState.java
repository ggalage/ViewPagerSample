package com.viewpagersample.sei.viewpagersample.viewpager.first;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.hannesdorfmann.mosby3.mvp.viewstate.RestorableViewState;
import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;
import com.viewpagersample.sei.viewpagersample.viewpager.first.data.FirstData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sei on 7/1/17.
 */

public class FirstViewState implements RestorableViewState<FirstView> {

    private final String KEY_STATE = "FirstVS-State";
    private final String KEY_DATA = "FirstVS-Data";
    private final String SNAPPY_KEY = "FirstSNAPPY-Data";
    private final String SNAPPY_LOG = "FirstSNAPPY-Error";

    private int currentViewState;
    private final int STATE_SHOW_LOADING = 0;
    private final int STATE_SHOW_CONTENT = 1;
    private final int STATE_SHOW_ERROR = 2;

    private FirstController firstController;

    private List<FirstData> firstDataList;

    public FirstViewState(FirstController firstController) {
        this.firstController = firstController;
    }

    @Override
    public void saveInstanceState(@NonNull Bundle out) {
        out.putInt(KEY_STATE, currentViewState);
        try {
            DB snappydb = DBFactory.open(firstController.getActivity(), KEY_DATA);
            if (firstDataList != null) {
                FirstData[] inputArray = firstDataList.toArray(new FirstData[0]);
                snappydb.put(SNAPPY_KEY, inputArray);
            }
            snappydb.close();
        } catch (SnappydbException e) {
            Log.e(SNAPPY_LOG, "write: " + e);
        }
    }

    @Override
    public RestorableViewState<FirstView> restoreInstanceState(Bundle in) {
        if (in == null) {
            return null;
        }
        currentViewState = in.getInt(KEY_STATE, 0);
        try {
            DB snappydb = DBFactory.open(firstController.getActivity(), KEY_DATA);
            FirstData[] returnedArray = snappydb.getObjectArray(SNAPPY_KEY, FirstData.class);
            snappydb.close();
            firstDataList = new ArrayList<>(Arrays.asList(returnedArray));
        } catch (SnappydbException e) {
            Log.e(SNAPPY_LOG, "read: " + e);
        }
        return this;
    }

    @Override
    public void apply(FirstView view, boolean retained) {
        switch (currentViewState) {
            case STATE_SHOW_LOADING:
                view.showLoadingView();
                break;
            case STATE_SHOW_CONTENT:
                view.setDataToController(firstDataList);
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
    public void setDataToViewState(List<FirstData> firstDataList) {
        this.firstDataList = firstDataList;
    }


}
