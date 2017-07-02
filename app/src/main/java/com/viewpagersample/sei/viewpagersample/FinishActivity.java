package com.viewpagersample.sei.viewpagersample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.annotations.Nullable;

/**
 * Created by sei on 7/1/17.
 */


//  Android sdk memory leak caused by InputMethodManager and RecyclerView. When closing app, if
//  you close from blank activity, this leak can be avoided.
public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
//            500 milliseconds
        }, 500);
    }
}
