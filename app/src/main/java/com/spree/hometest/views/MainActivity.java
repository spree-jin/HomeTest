package com.spree.hometest.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.spree.hometest.R;
import com.spree.hometest.adapter.MainRecyclerViewAdapter;
import com.spree.hometest.instance.MetaMutableLiveData;
import com.spree.hometest.instance.LoadingMutableLiveData;
import com.spree.hometest.models.Data;
import com.spree.hometest.models.Meta;
import com.spree.hometest.service.MainService;
import com.spree.hometest.viewmodels.MainViewModel;

import org.parceler.Parcels;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mainRecyclerView)
    RecyclerView mainRecyclerView;

    @BindView(R.id.txt_find_count)
    TextView txtFindCount;

    @BindView(R.id.layout_progress)
    View layoutProgress;

    @BindString(R.string.txt_find_count)
    String strFindCount;

    private MainRecyclerViewAdapter mainRecyclerViewAdapter;

    private MainViewModel mainViewModel;
    private Retrofit retrofit;
    private MainService mainService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainRecyclerViewAdapter = new MainRecyclerViewAdapter();
        mainRecyclerViewAdapter.setOnItemClickListener(new MainRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Data data) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("Product", Parcels.wrap(data));
                startActivity(intent);
            }
        });

        mainRecyclerView.setHasFixedSize(true);
        mainRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        mainRecyclerView.setAdapter(mainRecyclerViewAdapter);

        mainViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainViewModel.class);
        mainViewModel.getPagedListLiveData().observe(this, data -> {
            mainRecyclerViewAdapter.submitList(data);
        });

        MetaMutableLiveData.getInstance().observe(this, metaObserver);
        LoadingMutableLiveData.getInstance().observe(this, loadingObserver);
    }

    private Observer<Meta> metaObserver = meta -> {
        layoutProgress.setVisibility(View.GONE);
        txtFindCount.setText(meta.getTotalItems() + " " + strFindCount);
    };

    private Observer<Boolean> loadingObserver = on -> {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                layoutProgress.setVisibility(on ? View.VISIBLE:View.GONE);
            }
        });
    };

    @Override
    protected void onStop() {
        super.onStop();
        MetaMutableLiveData.getInstance().removeObserver(metaObserver);
        LoadingMutableLiveData.getInstance().removeObserver(loadingObserver);
    }

    @OnClick(R.id.txt_back)
    void onClick(View view){
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setMessage(R.string.txt_exit_app).setPositiveButton(R.string.txt_exit_ok, (dialog, which) -> {
            finish();
        }).setNegativeButton(R.string.txt_exit_cancel, null).show();
    }
}
