package com.viewpagersample.sei.viewpagersample.viewpager.first;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.viewpagersample.sei.viewpagersample.viewpager.first.data.FirstData;
import com.viewpagersample.sei.viewpagersample.viewpager.first.data.FirstDataProvider;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.ResourceObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sei on 7/1/17.
 */

public class FirstPresenter extends MvpBasePresenter<FirstView> {

    private ResourceObserver<List<FirstData>> subscriber;

    public void loadData() {
        getView().showLoadingView();
        subscriber = new ResourceObserver<List<FirstData>>() {
            @Override
            public void onNext(List<FirstData> firstData) {
                if (isViewAttached()) {
                    getView().setDataToController(firstData);
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()) {
                    getView().showErrorView();
                }

            }

            @Override
            public void onComplete() {
                if (isViewAttached()) {
                    getView().showContentView();
                }

            }
        };

        Observable.just(FirstDataProvider.provideData())
                .delay(1000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void loadUpdateData() {
        subscriber = new ResourceObserver<List<FirstData>>() {
            @Override
            public void onNext(List<FirstData> firstData) {
                if (isViewAttached()) {
                    getView().setDataToController(firstData);
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()) {
                    getView().showErrorView();
                }

            }

            @Override
            public void onComplete() {
                if (isViewAttached()) {
                    getView().showContentView();
                }

            }
        };

        Observable.just(FirstDataProvider.provideUpdateData())
                .delay(100, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void detachView(boolean retainPresenterInstance) {
        super.detachView(retainPresenterInstance);
        if (!retainPresenterInstance) {
            if (subscriber!= null) {
                subscriber.dispose();
            }
        }
    }

}
