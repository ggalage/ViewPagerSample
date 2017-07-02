package com.viewpagersample.sei.viewpagersample.viewpager.first;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.viewpagersample.sei.viewpagersample.viewpager.first.data.FirstData;
import com.viewpagersample.sei.viewpagersample.viewpager.first.viewholder.FirstVH;
import com.viewpagersample.sei.viewpagersample.viewpager.first.viewholder.FirstVHFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sei on 7/1/17.
 */

public class FirstRecyclerAdapter extends RecyclerView.Adapter {

    private FirstController firstController;
    private Map<Integer, FirstVHFactory> viewHolderFactories;

    private List<FirstData> firstDataList = new ArrayList<>();

    public FirstRecyclerAdapter(FirstController firstController, Map<Integer, FirstVHFactory>
            viewHolderFactories) {
        this.firstController = firstController;
        this.viewHolderFactories = viewHolderFactories;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder viewHolder = viewHolderFactories.get(viewType)
                .createViewHolder(parent, firstController);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((FirstVH) holder).bind(firstDataList.get(position));

    }

    @Override
    public int getItemCount() {
        return firstDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (firstDataList.size() == 0) {
            return 1;
        } else {
            FirstData data = firstDataList.get(position);
            return data.type;
        }
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.firstController = null;
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public void updateDataList(List<FirstData> firstDataList) {
        this.firstDataList.clear();
        this.firstDataList.addAll(firstDataList);
        notifyDataSetChanged();
    }

    public List<FirstData> getData() {
        return firstDataList;
    }
}
