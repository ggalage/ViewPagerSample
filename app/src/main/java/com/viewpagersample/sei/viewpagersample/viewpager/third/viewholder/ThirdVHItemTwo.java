package com.viewpagersample.sei.viewpagersample.viewpager.third.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.auto.factory.AutoFactory;
import com.viewpagersample.sei.viewpagersample.R;
import com.viewpagersample.sei.viewpagersample.viewpager.third.ThirdController;
import com.viewpagersample.sei.viewpagersample.viewpager.third.data.ThirdData;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sei on 7/1/17.
 */

@AutoFactory(implementing = ThirdVHFactory.class)
public class ThirdVHItemTwo extends ThirdVH {

    @BindView(R.id.third_controller_vh_item_two) TextView textView;
    private ThirdController thirdController;

    public ThirdVHItemTwo(ViewGroup parent, ThirdController thirdController) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.third_vh_item_two, parent,
                false));
        this.thirdController = thirdController;
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(ThirdData data) {
        if (data.text != null) {
            textView.setText(data.text);
        }
    }
}
