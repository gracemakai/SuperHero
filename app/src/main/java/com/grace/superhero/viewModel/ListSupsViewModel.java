package com.grace.superhero.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.grace.superhero.model.SupsModel;
import com.grace.superhero.api.SupsJSONHelper;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListSupsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<SupsModel>> supsModelMutableLiveData;

    private final String TAG = getClass().getSimpleName();

    public MutableLiveData<ArrayList<SupsModel>> getSupsModelMutableLiveData() {

        if (supsModelMutableLiveData == null){
            supsModelMutableLiveData = new MutableLiveData<>();

            new Thread() {
                @Override
                public void run() {
                    super.run();
                    getData();
                }
            }.start();
        }
        return supsModelMutableLiveData;
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

    private void getData() {
        ArrayList<SupsModel> supsModelArrayList = new ArrayList<>();

        Call<ArrayList<SupsModel>> supsModelCall = base().getAllSups();

        supsModelCall.enqueue(new Callback<ArrayList<SupsModel>>() {
            @Override
            public void onResponse(@NotNull Call<ArrayList<SupsModel>> call, @NotNull Response<ArrayList<SupsModel>> response) {

                if (!response.isSuccessful()){
                    Log.e(TAG, "onResponse: "+ response.errorBody());
                }

                Log.i(TAG, "onResponse: success");
                supsModelArrayList.addAll(response.body());
                supsModelMutableLiveData.setValue(supsModelArrayList);

            }

            @Override
            public void onFailure(@NotNull Call<ArrayList<SupsModel>> call, @NotNull Throwable t) {

                Log.e(TAG, "onFailure: ", t);
            }
        });

    }

}
