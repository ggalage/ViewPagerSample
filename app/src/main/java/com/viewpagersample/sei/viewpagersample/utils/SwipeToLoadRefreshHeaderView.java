package com.viewpagersample.sei.viewpagersample.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.aspsine.swipetoloadlayout.SwipeRefreshTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;
import com.viewpagersample.sei.viewpagersample.R;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by sei on 7/1/17.
 */

public class SwipeToLoadRefreshHeaderView extends FrameLayout implements SwipeRefreshTrigger, SwipeTrigger {

    private AVLoadingIndicatorView avi;


    public SwipeToLoadRefreshHeaderView(Context context) {
        this(context, null);
    }

    public SwipeToLoadRefreshHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwipeToLoadRefreshHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.swipelayout_loading_indicator, this);
        avi = (AVLoadingIndicatorView) findViewById(R.id.avi);

    }

    @Override
    public void onRefresh() {
        avi.show();

    }

    @Override
    public void onPrepare() {

    }

    @Override
    public void onMove(int i, boolean b, boolean b1) {

    }

    @Override
    public void onRelease() {


    }

    @Override
    public void onComplete() {


    }

    @Override
    public void onReset() {

    }
}
