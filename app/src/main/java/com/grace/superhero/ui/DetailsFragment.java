package com.grace.superhero.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.grace.superhero.R;
import com.grace.superhero.adapter.ExpandableListAdapter;
import com.grace.superhero.model.SupsDetailModel;
import com.grace.superhero.model.SupsModel;
import com.grace.superhero.viewModel.DetailsViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;

public class DetailsFragment extends Fragment {

    View view;
    ImageView imageView;
    TextView nameTextView;
    ExpandableListView expandableListView;

    DetailsViewModel detailsViewModel;
    SupsModel supsModel;

    public DetailsFragment(SupsModel supsModel) {
        this.supsModel = supsModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_details, container, false);

        detailsViewModel = new ViewModelProvider(this).get(DetailsViewModel.class);

        initViews();
        return view;
    }

    private void initViews() {

        imageView = view.findViewById(R.id.image_details);
        nameTextView = view.findViewById(R.id.name_details);
        expandableListView = view.findViewById(R.id.expandable_list);

        nameTextView.setText(supsModel.getName());
        loadImage(supsModel);
        fillListView(supsModel);

    }

    private void loadImage(SupsModel supsModel) {
        ImageLoader imageLoader = Coil.imageLoader(getContext());
        ImageRequest request = new ImageRequest.Builder(getContext())
                .data(supsModel.getImages().getMd())
                .crossfade(true)
                .target(imageView)
                .build();
        imageLoader.enqueue(request);
    }

    private void fillListView(SupsModel supsModel) {

        HashMap<String, List<SupsDetailModel>> expandableList =  detailsViewModel.fillHashMap(supsModel);
        List<String> expandableListTitle = new ArrayList(expandableList.keySet());
        expandableListView.setAdapter(new ExpandableListAdapter(getContext(), expandableListTitle, expandableList));
    }
}