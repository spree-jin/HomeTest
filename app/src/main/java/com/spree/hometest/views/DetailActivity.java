package com.spree.hometest.views;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.spree.hometest.R;
import com.spree.hometest.models.Data;

import org.parceler.Parcels;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.img_featured)
    ImageView imgFeatured;

    @BindView(R.id.img_icon)
    ImageView imgIcon;

    @BindView(R.id.txt_product)
    TextView txtProduct;

    @BindView(R.id.ratingbarSmall)
    RatingBar ratingBar;

    @BindView(R.id.txt_review)
    TextView txtReview;

    @BindView(R.id.txt_price)
    TextView txtPrice;

    @BindString(R.string.txt_review)
    String strReview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        bindingView(Parcels.unwrap(getIntent().getParcelableExtra("Product")));
    }

    private void bindingView(Data data){
        if(data.getAttributes().getZoomImageUrls() != null && data.getAttributes().getZoomImageUrls().size() > 0){
            Glide.with(this).load(data.getAttributes().getZoomImageUrls().get(0)).into(imgFeatured);
        }
        if(data.getAttributes().getIconImageUrls() != null && data.getAttributes().getCloseupImageUrls().size() > 0){
            Glide.with(this).load(data.getAttributes().getCloseupImageUrls().get(0)).into(imgIcon);
        }

        String heading  = data.getAttributes().getHeading();
        if(heading == null || heading.equals("null")){
            txtProduct.setText(data.getAttributes().getName());
        } else {
            txtProduct.setText(data.getAttributes().getName() + "ㆍ" + heading);
        }
        ratingBar.setMax(5);
        ratingBar.setStepSize(0.5f);
        ratingBar.setRating(data.getAttributes().getRating());
        txtReview.setText(data.getAttributes().getReviewsCount() + " " + strReview);
        txtReview.setPaintFlags(txtReview.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        txtPrice.setText(data.getAttributes().getPrice());
    }

    @OnClick(R.id.txt_back)
    void onClick(View view){
        finish();
    }
}
