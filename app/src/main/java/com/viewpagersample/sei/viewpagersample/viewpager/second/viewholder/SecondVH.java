package com.viewpagersample.sei.viewpagersample.viewpager.second.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.viewpagersample.sei.viewpagersample.viewpager.second.data.SecondData;

/**
 * Created by sei on 7/1/17.
 */

public abstract class SecondVH extends RecyclerView.ViewHolder {

    public SecondVH(View itemView) {
        super(itemView);
    }

    public abstract void bind(SecondData data);
}
