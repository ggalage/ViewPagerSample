package com.viewpagersample.sei.viewpagersample.viewpager.second.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.auto.factory.AutoFactory;
import com.viewpagersample.sei.viewpagersample.R;
import com.viewpagersample.sei.viewpagersample.viewpager.first.FirstController;
import com.viewpagersample.sei.viewpagersample.viewpager.second.SecondController;
import com.viewpagersample.sei.viewpagersample.viewpager.second.data.SecondData;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sei on 7/1/17.
 */

@AutoFactory(implementing = SecondVHFactory.class)
public class SecondVHItemTwo extends SecondVH {

    @BindView(R.id.second_controller_vh_item_two) TextView textView;
    private SecondController secondController;

    public SecondVHItemTwo(ViewGroup parent, SecondController secondController) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.second_vh_item_two, parent,
                false));
        this.secondController = secondController;
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(SecondData data) {
        if (data.text != null) {
            textView.setText(data.text);
        }
    }
}
