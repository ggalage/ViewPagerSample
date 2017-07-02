package com.viewpagersample.sei.viewpagersample.viewpager.first.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.viewpagersample.sei.viewpagersample.viewpager.first.data.FirstData;

/**
 * Created by sei on 7/1/17.
 */

public abstract class FirstVH extends RecyclerView.ViewHolder {
    public FirstVH(View itemView) {
        super(itemView);
    }

    public abstract void bind(FirstData data);
}
