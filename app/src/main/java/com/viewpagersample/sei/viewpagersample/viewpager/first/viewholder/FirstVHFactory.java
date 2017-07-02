package com.viewpagersample.sei.viewpagersample.viewpager.first.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.viewpagersample.sei.viewpagersample.viewpager.first.FirstController;

/**
 * Created by sei on 7/1/17.
 */

public interface FirstVHFactory {
    RecyclerView.ViewHolder createViewHolder(ViewGroup parent, FirstController firstController);
}
