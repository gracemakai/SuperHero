package com.grace.superhero.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.grace.superhero.api.SupsJSONHelper;
import com.grace.superhero.model.SupsDetailModel;
import com.grace.superhero.model.SupsModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsViewModel extends ViewModel {

    MutableLiveData<SupsModel> supsModelMutableLiveData;

    private final String TAG = getClass().getSimpleName();

    public MutableLiveData<SupsModel> getSupsModelMutableLiveData(String position) {

        if (supsModelMutableLiveData == null){
            supsModelMutableLiveData = new MutableLiveData<>();
            getData(position);
        }

        return supsModelMutableLiveData;
    }

    public HashMap<String, List<SupsDetailModel>> fillHashMap(SupsModel supsModel){

        HashMap<String, List<SupsDetailModel>> expandableListHash = new HashMap<>();
        List<String> headers = new ArrayList<>();

        headers.add("PowerStats");
        List<SupsDetailModel> powerStats = new ArrayList<>();
        powerStats.add(new SupsDetailModel("Intelligence: ", supsModel.getPowerstats().getIntelligence().toString()));
        powerStats.add(new SupsDetailModel("Combat " , supsModel.getPowerstats().getCombat().toString()));
        powerStats.add(new SupsDetailModel("Durability " , supsModel.getPowerstats().getDurability().toString()));
        powerStats.add(new SupsDetailModel("Power " ,supsModel.getPowerstats().getPower().toString()));
        powerStats.add(new SupsDetailModel("Speed " , supsModel.getPowerstats().getSpeed().toString()));
        powerStats.add(new SupsDetailModel("Strength" , supsModel.getPowerstats().getStrength().toString()));

        headers.add("Appearance");
        List<SupsDetailModel> appearance = new ArrayList<>();
        appearance.add(new SupsDetailModel("Gender " , supsModel.getAppearance().getGender()));
        appearance.add(new SupsDetailModel("Race " , supsModel.getAppearance().getRace()));
        appearance.add(new SupsDetailModel("Eye color " , supsModel.getAppearance().getEyeColor()));
        appearance.add(new SupsDetailModel("Hair color " , supsModel.getAppearance().getHairColor()));

        headers.add("Biography");
        List<SupsDetailModel> biography = new ArrayList<>();
        biography.add(new SupsDetailModel("Full name " , supsModel.getBiography().getFullName()));
        biography.add(new SupsDetailModel("Alter egos " , supsModel.getBiography().getAlterEgos()));
        biography.add(new SupsDetailModel("Place of birth " , supsModel.getBiography().getPlaceOfBirth()));
        biography.add(new SupsDetailModel("First appearance " , supsModel.getBiography().getFirstAppearance()));
        biography.add(new SupsDetailModel("Publisher " , supsModel.getBiography().getPublisher()));
        biography.add(new SupsDetailModel("Alignment " , supsModel.getBiography().getAlignment()));

        headers.add("Work");
        List<SupsDetailModel> work = new ArrayList<>();
        work.add(new SupsDetailModel("Occupation " , supsModel.getWork().getOccupation()));
        work.add(new SupsDetailModel("Base " , supsModel.getWork().getBase()));

        headers.add("Affiliations");
        List<SupsDetailModel> affiliations = new ArrayList<>();
        affiliations.add(new SupsDetailModel("Group Affiliation " , supsModel.getConnections().getGroupAffiliation()));
        affiliations.add(new SupsDetailModel("Relatives " , supsModel.getConnections().getRelatives()));

        expandableListHash.put(headers.get(2), biography);
        expandableListHash.put(headers.get(1), appearance);
        expandableListHash.put(headers.get(0), powerStats);
        expandableListHash.put(headers.get(3), work);
        expandableListHash.put(headers.get(4), affiliations);

        return expandableListHash;
    }

    private SupsJSONHelper base() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        String BASE_URL = "https://akabab.github.io/superhero-api/api/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();

        return retrofit.create(SupsJSONHelper.class);
    }

    private void getData(String position) {

        Call<SupsModel> supsModelCall = base().getForId(position);
        Log.i(TAG, "getData: " + supsModelCall.request().url());

        supsModelCall.enqueue(new Callback<SupsModel>() {
            @Override
            public void onResponse(Call<SupsModel> call, Response<SupsModel> response) {

                if (!response.isSuccessful()){
                    Log.e(TAG, "onResponse: not successful " + response.errorBody().toString());
                }

                supsModelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SupsModel> call, Throwable t) {

                Log.e(TAG, "onFailure: " + t.getMessage() );
            }
        });

    }


}
