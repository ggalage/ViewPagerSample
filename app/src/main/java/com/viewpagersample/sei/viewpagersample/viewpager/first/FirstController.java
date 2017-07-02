package com.viewpagersample.sei.viewpagersample.viewpager.first;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.hannesdorfmann.mosby3.conductor.viewstate.delegate.MvpViewStateConductorDelegateCallback;
import com.hannesdorfmann.mosby3.conductor.viewstate.delegate.MvpViewStateConductorLifecycleListener;
import com.viewpagersample.sei.viewpagersample.MainActivity;
import com.viewpagersample.sei.viewpagersample.R;
import com.viewpagersample.sei.viewpagersample.utils.LceSwitcher;
import com.viewpagersample.sei.viewpagersample.utils.RefWatcherController;
import com.viewpagersample.sei.viewpagersample.viewpager.ViewPagerController;
import com.viewpagersample.sei.viewpagersample.viewpager.first.dagger.DaggerFirstComponent;
import com.viewpagersample.sei.viewpagersample.viewpager.first.dagger.FirstModule;
import com.viewpagersample.sei.viewpagersample.viewpager.first.data.FirstData;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by sei on 7/1/17.
 */

public class FirstController extends RefWatcherController implements FirstView,
        MvpViewStateConductorDelegateCallback<FirstView, FirstPresenter, FirstViewState>,
        OnRefreshListener {

    @BindView(R.id.first_controller_error_view) TextView errorView;
    @BindView(R.id.first_controller_loading_view) AVLoadingIndicatorView loadingView;
    @BindView(R.id.swipe_target) RecyclerView recyclerView;
    @BindView(R.id.swipetoload_layout) SwipeToLoadLayout swipeToLoadLayout;

    @Inject MainActivity mainActivity;
    @Inject FirstRecyclerAdapter firstRecyclerAdapter;
    @Inject LinearLayoutManager linearLayoutManager;
    private FirstPresenter firstPresenter;
    private FirstViewState firstViewState;
    private boolean restoringViewState = false;

    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return inflater.inflate(R.layout.first_controller, container, false);
    }

    @Override
    protected void onViewBound(@NonNull final View view) {
        super.onViewBound(view);
        injectDependencies();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(firstRecyclerAdapter);
        swipeToLoadLayout.setOnRefreshListener(this);


    }

    @Override
    protected void onDestroyView(@NonNull View view) {
        recyclerView.setAdapter(null);
        swipeToLoadLayout.setOnRefreshListener(null);
        super.onDestroyView(view);
    }

    private void injectDependencies() {
        DaggerFirstComponent.builder()
                .viewPagerComponent(((ViewPagerController)getParentController()).getViewPagerComponent())
                .firstModule(new FirstModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onRefresh() {
        swipeToLoadLayout.setRefreshing(false);
        firstPresenter.loadUpdateData();

    }

    @Override
    public void onNewViewStateInstance() {
        showLoadingView();
    }

    public void onSwipeFirstTime() {
        firstPresenter.loadData();
    }

    @Override
    public void showLoadingView() {
        FirstViewState vs = getViewState();
        vs.setShowingLoading();
        LceSwitcher.showLoadingView(loadingView, recyclerView, errorView);

    }

    @Override
    public void showContentView() {
        FirstViewState vs = getViewState();
        vs.setShowingContent();
        LceSwitcher.showContentView(loadingView, recyclerView, errorView);
    }

    @Override
    public void showErrorView() {
        FirstViewState vs = getViewState();
        vs.setShowingError();
        LceSwitcher.showErrorView(loadingView, recyclerView, errorView);
    }

    @Override
    public void setDataToController(List<FirstData> data) {
        FirstViewState vs = getViewState();
        vs.setDataToViewState(data);
        firstRecyclerAdapter.updateDataList(data);
        firstRecyclerAdapter.notifyDataSetChanged();
    }

    public List<FirstData> getData() {
        return firstRecyclerAdapter == null ? null : firstRecyclerAdapter.getData();
    }

//  Initializer Block: Mosby lifecycle added to Controller
    {
        addLifecycleListener(getMosbyLifecycleListener());
    }

    private LifecycleListener getMosbyLifecycleListener() {
        return new MvpViewStateConductorLifecycleListener<>
                (this);
    }

        @Override
    public FirstViewState getViewState() {
        return firstViewState;
    }

    @Override
    public void setViewState(FirstViewState viewState) {
        this.firstViewState = viewState;
    }

    @NonNull
    @Override
    public FirstViewState createViewState() {
        return new FirstViewState(this);
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
    public FirstPresenter createPresenter() {
        return new FirstPresenter();
    }

    @Nullable
    @Override
    public FirstPresenter getPresenter() {
        return firstPresenter;
    }

    @Override
    public void setPresenter(@NonNull FirstPresenter presenter) {
        this.firstPresenter = presenter;
    }

    @NonNull
    @Override
    public FirstView getMvpView() {
        return (FirstView) this;
    }
}
