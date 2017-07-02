package com.viewpagersample.sei.viewpagersample.viewpager.third;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.viewpagersample.sei.viewpagersample.viewpager.third.data.ThirdData;
import com.viewpagersample.sei.viewpagersample.viewpager.third.viewholder.ThirdVH;
import com.viewpagersample.sei.viewpagersample.viewpager.third.viewholder.ThirdVHFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sei on 7/1/17.
 */

public class ThirdRecyclerAdapter extends RecyclerView.Adapter {

    private ThirdController thirdController;
    private Map<Integer, ThirdVHFactory> viewHolderFactories;

    private List<ThirdData> thirdDataList = new ArrayList<>();

    public ThirdRecyclerAdapter(ThirdController thirdController, Map<Integer, ThirdVHFactory>
            viewHolderFactories) {
        this.thirdController = thirdController;
        this.viewHolderFactories = viewHolderFactories;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder viewHolder = viewHolderFactories.get(viewType)
                .createViewHolder(parent, thirdController);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ThirdVH) holder).bind(thirdDataList.get(position));

    }

    @Override
    public int getItemCount() {
        return thirdDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (thirdDataList.size() == 0) {
            return 1;
        } else {
            ThirdData data = thirdDataList.get(position);
            return data.type;
        }
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.thirdController = null;
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public void updateDataList(List<ThirdData> thirdDataList) {
        this.thirdDataList.clear();
        this.thirdDataList.addAll(thirdDataList);
        notifyDataSetChanged();
    }

    public List<ThirdData> getData() {
        return thirdDataList;
    }
}
