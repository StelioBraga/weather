package com.mz.weather.Repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.mz.weather.Api.WeatherAPIClient;
import com.mz.weather.Api.WeatherAPIService;
import com.mz.weather.model.ResponseWeather;

import org.jetbrains.annotations.NotNull;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {
    private String[]  cities = {"Inhambane","Lisboa", "Madrid", "Paris", "Berlim", "Copenhaga", "Roma", "Londres", "Dublin", "Praga", "Viena"};

    public MutableLiveData<ResponseWeather> getWeather(){
       final MutableLiveData<ResponseWeather> mutableLiveData = new MutableLiveData<>();

        // get data weather api
        WeatherAPIService weatherAPIService = WeatherAPIClient
                .getRetrofit().create(WeatherAPIService.class);
        for (String  city : cities) {
            Call<ResponseWeather> weather = weatherAPIService.getWeather(city);
            weather.enqueue(new Callback<ResponseWeather>() {
                @Override
                public void onResponse(Call<ResponseWeather> call, @NotNull Response<ResponseWeather> response) {
                    if (response.code() == 200) {
                        ResponseWeather responseWeather = response.body();
                        mutableLiveData.setValue(responseWeather);
                    }if(response.code() == HttpURLConnection.HTTP_BAD_REQUEST){

                    }
                }
                @Override
                public void onFailure(Call<ResponseWeather> call, Throwable t) {
                    Log.v("agg",String.valueOf(call ));
                }
            });
        }
        return mutableLiveData;

    }
}
