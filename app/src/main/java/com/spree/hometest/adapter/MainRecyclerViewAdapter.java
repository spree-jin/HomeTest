package com.spree.hometest.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.spree.hometest.R;
import com.spree.hometest.models.Data;
import com.spree.hometest.viewholder.MainRecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewHolder> {

    private List<Data> dataList = new ArrayList<>();

    @NonNull
    @Override
    public MainRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainRecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_product, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerViewHolder holder, int position) {
        holder.setData(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addDataList(List<Data> dataList) {
        this.dataList.addAll(dataList);
    }
}
