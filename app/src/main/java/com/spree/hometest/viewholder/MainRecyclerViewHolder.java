package com.spree.hometest.viewholder;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.spree.hometest.R;
import com.spree.hometest.models.Attributes;
import com.spree.hometest.models.Data;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainRecyclerViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img_product)
    ImageView imgProduct;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_price)
    TextView txtPrice;
    @BindView(R.id.txt_rating)
    TextView txtRating;

    public MainRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(Data data){

        Attributes attributes = data.getAttributes();
        if(attributes.getDefaultImageUrls().size() > 0){
            Glide
                .with(itemView)
                .load(attributes.getDefaultImageUrls().get(0))
                .into(imgProduct);
        }
        txtName.setText(attributes.getName());
        txtPrice.setText(attributes.getPrice());
        txtRating.setText(String.format("%s", attributes.getRating()));
    }
}
