package com.grace.superhero.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.grace.superhero.R;
import com.grace.superhero.adapter.AllSupsRecyclerAdapter;
import com.grace.superhero.listener.RecyclerTouchListener;
import com.grace.superhero.model.SupsModel;
import com.grace.superhero.viewModel.ListSupsViewModel;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class ListSupsFragment extends Fragment implements
        RecyclerTouchListener.ClickListener {

    View view;
    RecyclerView recyclerView;
    SearchView searchView;

    String TAG = getClass().getSimpleName();

    ListSupsViewModel listSupsViewModel;
    AllSupsRecyclerAdapter allSupsRecyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list_sups, container, false);

        listSupsViewModel = new ViewModelProvider(this).get(ListSupsViewModel.class);
        initViews();

        hideSoftKeyboard();
        return view;
    }


    private void initViews() {
        searchView = view.findViewById(R.id.searchView);
        searchView.clearFocus();
        recyclerView = view.findViewById(R.id.allSupsRecycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

/*
                if (listSupsViewModel.getSupsModelMutableLiveData().getValue().contains(query)){
                    allSupsRecyclerAdapter.getFilter().filter(query);
                    return true;
                }*/
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                allSupsRecyclerAdapter.getFilter().filter(newText);
                return true;
            }
        });

        listSupsViewModel.getSupsModelMutableLiveData().observe(this, supsModels -> {

            allSupsRecyclerAdapter = new AllSupsRecyclerAdapter(getContext(),
                    supsModels, this);
            recyclerView.setAdapter(allSupsRecyclerAdapter);

        });
    }

    public void hideSoftKeyboard() {
        if(getActivity().getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        }
    }


    @Override
    public void onClick(SupsModel supsModel) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag_container, new DetailsFragment(supsModel)).addToBackStack("");
        fragmentTransaction.commit();
    }

    @Override
    public void onLongClick(View view, int position) {

    }
}