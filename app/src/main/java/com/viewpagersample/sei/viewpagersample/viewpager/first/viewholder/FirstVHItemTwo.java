package com.viewpagersample.sei.viewpagersample.viewpager.first.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.auto.factory.AutoFactory;
import com.viewpagersample.sei.viewpagersample.R;
import com.viewpagersample.sei.viewpagersample.viewpager.first.FirstController;
import com.viewpagersample.sei.viewpagersample.viewpager.first.data.FirstData;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sei on 7/1/17.
 */

@AutoFactory(implementing = FirstVHFactory.class)
public class FirstVHItemTwo extends FirstVH {

    @BindView(R.id.first_controller_vh_item_two) TextView textView;
    private FirstController firstController;

    public FirstVHItemTwo(ViewGroup parent, FirstController firstController) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.first_vh_item_two, parent,
                false));
        this.firstController = firstController;
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(FirstData data) {
        if (data.text != null) {
            textView.setText(data.text);
        }
    }
}
