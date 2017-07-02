package com.viewpagersample.sei.viewpagersample.viewpager.third.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.viewpagersample.sei.viewpagersample.viewpager.third.data.ThirdData;

/**
 * Created by sei on 7/1/17.
 */

public abstract class ThirdVH extends RecyclerView.ViewHolder {

    public ThirdVH(View itemView) {
        super(itemView);
    }

    public abstract void bind(ThirdData data);
}
