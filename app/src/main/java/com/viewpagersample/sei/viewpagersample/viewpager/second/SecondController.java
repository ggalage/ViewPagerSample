package com.viewpagersample.sei.viewpagersample.viewpager.second;

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
import com.viewpagersample.sei.viewpagersample.viewpager.second.dagger.DaggerSecondComponent;
import com.viewpagersample.sei.viewpagersample.viewpager.second.dagger.SecondModule;
import com.viewpagersample.sei.viewpagersample.viewpager.second.data.SecondData;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by sei on 7/1/17.
 */

public class SecondController extends RefWatcherController implements SecondView,
        MvpViewStateConductorDelegateCallback<SecondView, SecondPresenter, SecondViewState>, OnRefreshListener{

    @BindView(R.id.second_controller_error_view) TextView errorView;
    @BindView(R.id.second_controller_loading_view) AVLoadingIndicatorView loadingView;
    @BindView(R.id.swipe_target) RecyclerView recyclerView;
    @BindView(R.id.swipetoload_layout) SwipeToLoadLayout swipeToLoadLayout;

    @Inject MainActivity mainActivity;
    @Inject SecondRecyclerAdapter secondRecyclerAdapter;
    @Inject LinearLayoutManager linearLayoutManager;
    private SecondPresenter secondPresenter;
    private SecondViewState secondViewState;
    private boolean restoringViewState = false;

    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return inflater.inflate(R.layout.second_controller, container, false);
    }

    @Override
    protected void onViewBound(@NonNull final View view) {
        super.onViewBound(view);
        injectDependencies();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(secondRecyclerAdapter);
        swipeToLoadLayout.setOnRefreshListener(this);


    }

    @Override
    protected void onDestroyView(@NonNull View view) {
        recyclerView.setAdapter(null);
        swipeToLoadLayout.setOnRefreshListener(null);
        super.onDestroyView(view);
    }

    private void injectDependencies() {
        DaggerSecondComponent.builder()
                .viewPagerComponent(((ViewPagerController)getParentController()).getViewPagerComponent())
                .secondModule(new SecondModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onRefresh() {
        swipeToLoadLayout.setRefreshing(false);
        secondPresenter.loadUpdateData();

    }

    @Override
    public void onNewViewStateInstance() {
        secondPresenter.loadData();

    }

    @Override
    public void showLoadingView() {
        SecondViewState vs = getViewState();
        vs.setShowingLoading();
        LceSwitcher.showLoadingView(loadingView, recyclerView, errorView);

    }

    @Override
    public void showContentView() {
        SecondViewState vs = getViewState();
        vs.setShowingContent();
        LceSwitcher.showContentView(loadingView, recyclerView, errorView);
    }

    @Override
    public void showErrorView() {
        SecondViewState vs = getViewState();
        vs.setShowingError();
        LceSwitcher.showErrorView(loadingView, recyclerView, errorView);
    }

    @Override
    public void setDataToController(List<SecondData> data) {
        SecondViewState vs = getViewState();
        vs.setDataToViewState(data);
        secondRecyclerAdapter.updateDataList(data);
        secondRecyclerAdapter.notifyDataSetChanged();
    }

    public List<SecondData> getData() {
        return secondRecyclerAdapter == null ? null : secondRecyclerAdapter.getData();
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
    public SecondViewState getViewState() {
        return secondViewState;
    }

    @Override
    public void setViewState(SecondViewState viewState) {
        this.secondViewState = viewState;
    }

    @NonNull
    @Override
    public SecondViewState createViewState() {
        return new SecondViewState(this);
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
    public SecondPresenter createPresenter() {
        return new SecondPresenter();
    }

    @Nullable
    @Override
    public SecondPresenter getPresenter() {
        return secondPresenter;
    }

    @Override
    public void setPresenter(@NonNull SecondPresenter presenter) {
        this.secondPresenter = presenter;
    }

    @NonNull
    @Override
    public SecondView getMvpView() {
        return (SecondView) this;
    }
}
