package com.viewpagersample.sei.viewpagersample.viewpager.third.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.viewpagersample.sei.viewpagersample.viewpager.first.FirstController;
import com.viewpagersample.sei.viewpagersample.viewpager.third.ThirdController;

/**
 * Created by sei on 7/1/17.
 */

public interface ThirdVHFactory {
    RecyclerView.ViewHolder createViewHolder(ViewGroup parent, ThirdController thirdController);
}
