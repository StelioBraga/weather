package com.mz.weather;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mz.weather.adapter.WeatherAdapter;
import com.mz.weather.model.ResponseWeather;
import com.mz.weather.service.WeatherAPIClient;
import com.mz.weather.service.WeatherAPIService;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_weather ;
    public List<ResponseWeather> responseWeatherList = new ArrayList<>();
    Context context;
    private String[]  cities = {"Inhambane","Lisboa", "Madrid", "Paris", "Berlim", "Copenhaga", "Roma", "Londres", "Dublin", "Praga", "Viena"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // change app title
        Objects.requireNonNull(getSupportActionBar()).setTitle("Tempo");

        // initialization
        context = this;
        rv_weather = findViewById(R.id.rv_wheather);

        // set list layout style grid
        rv_weather.setLayoutManager(new GridLayoutManager(context, 2) );

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
                        responseWeatherList.add(responseWeather);
                         // TODO
                        // rv
                        WeatherAdapter weatherAdapter = new WeatherAdapter(context, responseWeatherList);
                        rv_weather.setAdapter(weatherAdapter);
                        weatherAdapter.notifyDataSetChanged();
                    }
                }
                @Override
                public void onFailure(Call<ResponseWeather> call, Throwable t) {
                }
            });
        }

    }

}
 // total 36 hours