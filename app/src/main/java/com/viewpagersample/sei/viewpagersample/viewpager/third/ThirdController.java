package com.viewpagersample.sei.viewpagersample.viewpager.third;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.bluelinelabs.conductor.Controller;
import com.hannesdorfmann.mosby3.conductor.viewstate.delegate.MvpViewStateConductorDelegateCallback;
import com.hannesdorfmann.mosby3.conductor.viewstate.delegate.MvpViewStateConductorLifecycleListener;
import com.viewpagersample.sei.viewpagersample.MainActivity;
import com.viewpagersample.sei.viewpagersample.R;
import com.viewpagersample.sei.viewpagersample.utils.LceSwitcher;
import com.viewpagersample.sei.viewpagersample.utils.RefWatcherController;
import com.viewpagersample.sei.viewpagersample.viewpager.ViewPagerController;
import com.viewpagersample.sei.viewpagersample.viewpager.third.dagger.DaggerThirdComponent;
import com.viewpagersample.sei.viewpagersample.viewpager.third.dagger.ThirdModule;
import com.viewpagersample.sei.viewpagersample.viewpager.third.data.ThirdData;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by sei on 7/1/17.
 */

public class ThirdController extends RefWatcherController implements ThirdView,
        MvpViewStateConductorDelegateCallback<ThirdView, ThirdPresenter, ThirdViewState>, OnRefreshListener{

    @BindView(R.id.third_controller_error_view) TextView errorView;
    @BindView(R.id.third_controller_loading_view) AVLoadingIndicatorView loadingView;
    @BindView(R.id.swipe_target) RecyclerView recyclerView;
    @BindView(R.id.swipetoload_layout) SwipeToLoadLayout swipeToLoadLayout;

    @Inject MainActivity mainActivity;
    @Inject ThirdRecyclerAdapter thirdRecyclerAdapter;
    @Inject LinearLayoutManager linearLayoutManager;
    private ThirdPresenter thirdPresenter;
    private ThirdViewState thirdViewState;
    private boolean restoringViewState = false;

    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return inflater.inflate(R.layout.third_controller, container, false);
    }

    @Override
    protected void onViewBound(@NonNull final View view) {
        super.onViewBound(view);
        injectDependencies();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(thirdRecyclerAdapter);
        swipeToLoadLayout.setOnRefreshListener(this);


    }

    @Override
    protected void onDestroyView(@NonNull View view) {
        recyclerView.setAdapter(null);
        swipeToLoadLayout.setOnRefreshListener(null);
        super.onDestroyView(view);
    }

    private void injectDependencies() {
        DaggerThirdComponent.builder()
                .viewPagerComponent(((ViewPagerController)getParentController()).getViewPagerComponent())
                .thirdModule(new ThirdModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onRefresh() {
        swipeToLoadLayout.setRefreshing(false);
        thirdPresenter.loadUpdateData();

    }

    @Override
    public void onNewViewStateInstance() {
        showLoadingView();
    }

    public void onSwipeFirstTime() {
        thirdPresenter.loadData();
    }

    @Override
    public void showLoadingView() {
        ThirdViewState vs = getViewState();
        vs.setShowingLoading();
        LceSwitcher.showLoadingView(loadingView, recyclerView, errorView);

    }

    @Override
    public void showContentView() {
        ThirdViewState vs = getViewState();
        vs.setShowingContent();
        LceSwitcher.showContentView(loadingView, recyclerView, errorView);
    }

    @Override
    public void showErrorView() {
        ThirdViewState vs = getViewState();
        vs.setShowingError();
        LceSwitcher.showErrorView(loadingView, recyclerView, errorView);
    }

    @Override
    public void setDataToController(List<ThirdData> data) {
        ThirdViewState vs = getViewState();
        vs.setDataToViewState(data);
        thirdRecyclerAdapter.updateDataList(data);
        thirdRecyclerAdapter.notifyDataSetChanged();
    }

    public List<ThirdData> getData() {
        return thirdRecyclerAdapter == null ? null : thirdRecyclerAdapter.getData();
    }

    //  Initializer Block: Mosby lifecycle added to Controller
    {
        addLifecycleListener(getMosbyLifecycleListener());
    }

    private Controller.LifecycleListener getMosbyLifecycleListener() {
        return new MvpViewStateConductorLifecycleListener<>
                (this);
    }

    @Override
    public ThirdViewState getViewState() {
        return thirdViewState;
    }

    @Override
    public void setViewState(ThirdViewState viewState) {
        this.thirdViewState = viewState;
    }

    @NonNull
    @Override
    public ThirdViewState createViewState() {
        return new ThirdViewState(this);
    }

    @Override
    public void setRestoringViewState(boolean restoringViewState) {
        this.restoringViewState = restoringViewState;
    }

    @Override
    public boolean isRestoringViewState() {
        return restoringViewState;
    }

    @Override
    public void onViewStateInstanceRestored(boolean instanceStateRetained) {
        //  things that happen after the viewstate is restored.  instanceStateRetained = true if it
        //  was orientation change...  false if app was killed and coming back alive
    }

    @NonNull
    @Override
    public ThirdPresenter createPresenter() {
        return new ThirdPresenter();
    }

    @Nullable
    @Override
    public ThirdPresenter getPresenter() {
        return thirdPresenter;
    }

    @Override
    public void setPresenter(@NonNull ThirdPresenter presenter) {
        this.thirdPresenter = presenter;
    }

    @NonNull
    @Override
    public ThirdView getMvpView() {
        return (ThirdView) this;
    }
}
