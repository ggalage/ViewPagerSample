package com.viewpagersample.sei.viewpagersample.viewpager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.support.RouterPagerAdapter;
import com.hannesdorfmann.mosby3.conductor.viewstate.delegate.MvpViewStateConductorDelegateCallback;
import com.viewpagersample.sei.viewpagersample.MainActivity;
import com.viewpagersample.sei.viewpagersample.R;
import com.viewpagersample.sei.viewpagersample.utils.RefWatcherController;
import com.viewpagersample.sei.viewpagersample.viewpager.dagger.DaggerViewPagerComponent;
import com.viewpagersample.sei.viewpagersample.viewpager.dagger.ViewPagerComponent;
import com.viewpagersample.sei.viewpagersample.viewpager.dagger.ViewPagerModule;
import com.viewpagersample.sei.viewpagersample.viewpager.first.FirstController;
import com.viewpagersample.sei.viewpagersample.viewpager.second.SecondController;
import com.viewpagersample.sei.viewpagersample.viewpager.third.ThirdController;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by sei on 7/1/17.
 */

public class ViewPagerController extends RefWatcherController{

    private static final String TAG_FIRST = "FirstController";
    private static final String TAG_SECOND = "SecondController";
    private static final String TAG_THIRD = "ThirdController";
    private static final String tabTitles[] = new String[] {"First", "Second", "Third"};

    @BindView(R.id.view_pager) ViewPager viewPager;
    @BindView(R.id.tab_layout) TabLayout tabLayout;

    @Inject MainActivity mainActivity;
    private ViewPagerComponent viewPagerComponent;
    private FirstController firstController;
    private SecondController secondController;
    private ThirdController thirdController;

    private boolean isFirstInitSwipe = true;
    private boolean isThirdInitSwipe = true;

    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return inflater.inflate(R.layout.viewpager_controller, container, false);
    }

    @Override
    protected void onViewBound(@NonNull final View view) {
        super.onViewBound(view);
        buildDependencies();
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new RouterPagerAdapter(this) {
            @Override
            public void configureRouter(@NonNull Router router, int position) {
                switch (position) {
                    case 0:
                        if (!router.hasRootController()) {
                            firstController = new FirstController();
                            router.setRoot(RouterTransaction.with(firstController).tag(TAG_FIRST));
                        }
                        break;
                    case 1:
                        if (!router.hasRootController()) {
                            secondController = new SecondController();
                            router.setRoot(RouterTransaction.with(secondController).tag(TAG_SECOND));
                        }
                        break;
                    case 2:
                        if (!router.hasRootController()) {
                            thirdController = new ThirdController();
                            router.setRoot(RouterTransaction.with(thirdController).tag(TAG_THIRD));
                        }
                        break;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                Router createdRouter = (Router) super.instantiateItem(container, position);
                switch (position) {
                    case 0:
                        firstController = (FirstController) createdRouter.getControllerWithTag
                                (TAG_FIRST);
                        break;
                    case 1:
                        secondController = (SecondController) createdRouter.getControllerWithTag
                                (TAG_SECOND);
                        break;
                    case 2:
                        thirdController = (ThirdController) createdRouter.getControllerWithTag
                                (TAG_THIRD);
                        break;
                }
                return createdRouter;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabTitles[position];
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        if (isFirstInitSwipe) {
                            isFirstInitSwipe = false;
                            firstController.onSwipeFirstTime();
                        }
                        break;
                    case 1:
                        break;
                    case 2:
                        if (isThirdInitSwipe) {
                            isThirdInitSwipe = false;
                            thirdController.onSwipeFirstTime();
                        }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(1);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onDestroyView(@NonNull View view) {
        if (getActivity() != null) {
            if (!getActivity().isChangingConfigurations()) {
                viewPager.clearOnPageChangeListeners();
                viewPager.setAdapter(null);
            }
        }
        tabLayout.setupWithViewPager(null);
        super.onDestroyView(view);
    }

    private void buildDependencies() {
        viewPagerComponent = DaggerViewPagerComponent.builder()
                .mainActivityComponent(((MainActivity)getActivity()).getMainActivityComponent())
                .viewPagerModule(new ViewPagerModule(this))
                .build();
    }

    public ViewPagerComponent getViewPagerComponent() {
        return viewPagerComponent;
    }
}
