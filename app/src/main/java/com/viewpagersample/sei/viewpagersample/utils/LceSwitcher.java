package com.viewpagersample.sei.viewpagersample.utils;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by sei on 7/1/17.
 */

public class LceSwitcher {

    private LceSwitcher() {
    }

    public static void showLoadingView(@NonNull View loadingView, @NonNull View contentView,
                                       @NonNull View errorView) {
        loadingView.setVisibility(View.VISIBLE);
        contentView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);

    }

    public static void showContentView(@NonNull View loadingView, @NonNull View contentView,
                                       @NonNull View errorView) {
        loadingView.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);

    }

    public static void showErrorView(@NonNull View loadingView, @NonNull View contentView,
                                       @NonNull View errorView) {
        loadingView.setVisibility(View.GONE);
        contentView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);

    }
}
