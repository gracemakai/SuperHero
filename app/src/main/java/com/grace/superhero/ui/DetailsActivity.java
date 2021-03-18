package com.grace.superhero.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.grace.superhero.R;
import com.grace.superhero.adapter.ExpandableListAdapter;
import com.grace.superhero.model.SupsDetailModel;
import com.grace.superhero.model.SupsModel;
import com.grace.superhero.viewModel.DetailsViewModel;
import com.jaredrummler.cyanea.app.CyaneaAppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;

public class DetailsActivity extends CyaneaAppCompatActivity {


    private final String TAG = getClass().getSimpleName();
    SupsModel supsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


    }


}