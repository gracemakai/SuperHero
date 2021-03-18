package com.grace.superhero.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grace.superhero.R;
import com.grace.superhero.listener.RecyclerTouchListener;
import com.grace.superhero.model.SupsModel;
import com.grace.superhero.ui.DetailsActivity;
import com.grace.superhero.ui.ListSupsActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;

public class AllSupsRecyclerAdapter extends
        RecyclerView.Adapter<AllSupsRecyclerAdapter.ViewHolder> implements Filterable {

    View view;
    Context context;
    ArrayList<SupsModel> supsModelArrayList;
    ArrayList<SupsModel> filteredList;
    List<SupsModel> exampleListFull;

    final private RecyclerTouchListener.ClickListener clickListener;

    public AllSupsRecyclerAdapter(Context context, ArrayList<SupsModel> supsModelArrayList,
                                  RecyclerTouchListener.ClickListener clickListener) {
        this.context = context;
        this.supsModelArrayList = supsModelArrayList;
        this.filteredList = supsModelArrayList;
        exampleListFull = new ArrayList<>(supsModelArrayList);
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = LayoutInflater.from(context).inflate(R.layout.all_sups_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        SupsModel supsModel = filteredList.get(position);

        loadImage(holder.imageView, supsModel);

        Log.i(getClass().getSimpleName(), "onClick: " + supsModel.getWork().getOccupation());
        holder.textView.setText(supsModel.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(filteredList.get(position));
            }
        });

    }

    private void loadImage(ImageView imageView, SupsModel supsModel) {

        new Thread(){
            @Override
            public void run() {
                super.run();

                ImageLoader imageLoader = Coil.imageLoader(context);

                ImageRequest request = new ImageRequest.Builder(context)
                        .data(supsModel.getImages().getMd())
                        .crossfade(true)
                        .target(imageView)
                        .build();
                imageLoader.enqueue(request);
            }
        }.start();
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String searchString = constraint.toString();

                if (searchString.isEmpty()){
                    filteredList = supsModelArrayList;
                }else {
                    ArrayList<SupsModel> tempFilteredList = new ArrayList<>();

                    for (SupsModel supsModel : supsModelArrayList){
                        if (supsModel.getName().toLowerCase().contains(searchString)){
                            tempFilteredList.add(supsModel);
                        }
                    }

                    filteredList = tempFilteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filterResults;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                notifyDataSetChanged();
            }
        };
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.all_sups_imageView);
            textView = itemView.findViewById(R.id.all_sups_textView);

        }

    }
}
