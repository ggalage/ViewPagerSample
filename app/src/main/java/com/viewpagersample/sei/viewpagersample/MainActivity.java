package com.viewpagersample.sei.viewpagersample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.viewpagersample.sei.viewpagersample.dagger.DaggerMainActivityComponent;
import com.viewpagersample.sei.viewpagersample.dagger.MainActivityComponent;
import com.viewpagersample.sei.viewpagersample.dagger.MainActivityModule;
import com.viewpagersample.sei.viewpagersample.viewpager.ViewPagerController;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sei on 7/1/17.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_container) ViewGroup mainContainer;

    private Router router;
    private MainActivityComponent mainActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        buildDependency();
        ButterKnife.bind(this);
        if (router == null) {
            router = Conductor.attachRouter(this, mainContainer, savedInstanceState);
        }
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(new ViewPagerController()));
        }

    }

    protected void buildDependency() {
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .build();
    }

    public MainActivityComponent getMainActivityComponent() {
        return mainActivityComponent;
    }

    @Override
    public void onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed();
            startActivity(new Intent(this, FinishActivity.class));
            finish();
        }
    }


}
