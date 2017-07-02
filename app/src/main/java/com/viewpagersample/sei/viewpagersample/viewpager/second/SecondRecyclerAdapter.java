package com.viewpagersample.sei.viewpagersample.viewpager.second;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.viewpagersample.sei.viewpagersample.viewpager.second.data.SecondData;
import com.viewpagersample.sei.viewpagersample.viewpager.second.viewholder.SecondVH;
import com.viewpagersample.sei.viewpagersample.viewpager.second.viewholder.SecondVHFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sei on 7/1/17.
 */

public class SecondRecyclerAdapter extends RecyclerView.Adapter {

    private SecondController secondController;
    private Map<Integer, SecondVHFactory> viewHolderFactories;

    private List<SecondData> secondDataList = new ArrayList<>();

    public SecondRecyclerAdapter(SecondController secondController, Map<Integer, SecondVHFactory>
            viewHolderFactories) {
        this.secondController = secondController;
        this.viewHolderFactories = viewHolderFactories;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder viewHolder = viewHolderFactories.get(viewType)
                .createViewHolder(parent, secondController);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SecondVH) holder).bind(secondDataList.get(position));

    }

    @Override
    public int getItemCount() {
        return secondDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (secondDataList.size() == 0) {
            return 1;
        } else {
            SecondData data = secondDataList.get(position);
            return data.type;
        }
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.secondController = null;
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public void updateDataList(List<SecondData> secondDataList) {
        this.secondDataList.clear();
        this.secondDataList.addAll(secondDataList);
        notifyDataSetChanged();
    }

    public List<SecondData> getData() {
        return secondDataList;
    }
}
