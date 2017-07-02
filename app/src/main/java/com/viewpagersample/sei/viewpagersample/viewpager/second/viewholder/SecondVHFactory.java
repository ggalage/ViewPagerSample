package com.viewpagersample.sei.viewpagersample.viewpager.second.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.viewpagersample.sei.viewpagersample.viewpager.second.SecondController;

/**
 * Created by sei on 7/1/17.
 */

public interface SecondVHFactory {
    RecyclerView.ViewHolder createViewHolder(ViewGroup parent, SecondController secondController);
}
