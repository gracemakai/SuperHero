package com.grace.superhero.api;

import com.grace.superhero.model.SupsModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SupsJSONHelper {

    @GET("all.json")
    Call<ArrayList<SupsModel>> getAllSups();

    @GET("id/{id}.json")
    Call<SupsModel> getForId(@Path("id") String id);
}
