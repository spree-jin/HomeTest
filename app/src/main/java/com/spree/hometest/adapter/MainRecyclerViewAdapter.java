package com.spree.hometest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.spree.hometest.R;
import com.spree.hometest.models.Data;
import com.spree.hometest.viewholder.MainRecyclerViewHolder;

public class MainRecyclerViewAdapter extends PagedListAdapter<Data, MainRecyclerViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(View view, int position, Data data);
    }

    private OnItemClickListener onItemClickListener;

    public MainRecyclerViewAdapter(){
        this(new DiffUtil.ItemCallback<Data>() {
            @Override
            public boolean areItemsTheSame(@NonNull Data oldItem, @NonNull Data newItem) {
                return oldItem.getId().equals(newItem.getId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Data oldItem, @NonNull Data newItem) {
                try{
                    return oldItem.getAttributes().getName().equals(newItem.getAttributes().getName()) &&
                            oldItem.getAttributes().getHeading().equals(newItem.getAttributes().getHeading());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
    }

    protected MainRecyclerViewAdapter(@NonNull DiffUtil.ItemCallback<Data> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MainRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainRecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_product, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerViewHolder holder, int position) {
        holder.itemView.setOnClickListener(v -> {
            if(onItemClickListener != null)
                onItemClickListener.onItemClick(v, position, getItem(position));
        });
        Data data = getItem(position);
        if(data != null) holder.setData(data);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
}
