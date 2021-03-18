package com.grace.superhero.ui;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;

import com.grace.superhero.adapter.AllSupsRecyclerAdapter;
import com.grace.superhero.listener.RecyclerTouchListener;
import com.grace.superhero.viewModel.DetailsViewModel;
import com.grace.superhero.viewModel.ListSupsViewModel;
import com.grace.superhero.R;
import com.grace.superhero.model.SupsModel;
import com.jaredrummler.cyanea.app.CyaneaAppCompatActivity;

import java.util.ArrayList;

public class ListSupsActivity extends CyaneaAppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sups);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frag_container, new ListSupsFragment());
        fragmentTransaction.commit();

    }

}