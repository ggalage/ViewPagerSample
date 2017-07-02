package com.viewpagersample.sei.viewpagersample.viewpager.second;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.hannesdorfmann.mosby3.mvp.viewstate.RestorableViewState;
import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;
import com.viewpagersample.sei.viewpagersample.viewpager.second.data.SecondData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sei on 7/1/17.
 */

public class SecondViewState implements RestorableViewState<SecondView> {

    private final String KEY_STATE = "SecondVS-State";
    private final String KEY_DATA = "SecondVS-Data";
    private final String SNAPPY_KEY = "SecondSNAPPY-Data";
    private final String SNAPPY_LOG = "SecondSNAPPY-Error";

    private int currentViewState;
    private final int STATE_SHOW_LOADING = 0;
    private final int STATE_SHOW_CONTENT = 1;
    private final int STATE_SHOW_ERROR = 2;

    private SecondController secondController;

    private List<SecondData> secondDataList;

    public SecondViewState(SecondController secondController) {
        this.secondController = secondController;
    }

    @Override
    public void saveInstanceState(@NonNull Bundle out) {
        out.putInt(KEY_STATE, currentViewState);
        try {
            DB snappydb = DBFactory.open(secondController.getActivity(), KEY_DATA);
            if (secondDataList != null) {
                SecondData[] inputArray = secondDataList.toArray(new SecondData[0]);
                snappydb.put(SNAPPY_KEY, inputArray);
            }
            snappydb.close();
        } catch (SnappydbException e) {
            Log.e(SNAPPY_LOG, "write: " + e);
        }
    }

    @Override
    public RestorableViewState<SecondView> restoreInstanceState(Bundle in) {
        if (in == null) {
            return null;
        }
        currentViewState = in.getInt(KEY_STATE, 0);
        try {
            DB snappydb = DBFactory.open(secondController.getActivity(), KEY_DATA);
            SecondData[] returnedArray = snappydb.getObjectArray(SNAPPY_KEY, SecondData.class);
            snappydb.close();
            secondDataList = new ArrayList<>(Arrays.asList(returnedArray));
        } catch (SnappydbException e) {
            Log.e(SNAPPY_LOG, "read: " + e);
        }
        return this;
    }

    @Override
    public void apply(SecondView view, boolean retained) {
        switch (currentViewState) {
            case STATE_SHOW_LOADING:
                view.showLoadingView();
                break;
            case STATE_SHOW_CONTENT:
                view.setDataToController(secondDataList);
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
    public void setDataToViewState(List<SecondData> secondDataList) {
        this.secondDataList = secondDataList;
    }
}
