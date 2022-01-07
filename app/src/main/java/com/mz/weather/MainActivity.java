package com.mz.weather;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mz.weather.adapter.WeatherAdapter;
import com.mz.weather.model.ResponseWeather;
import com.mz.weather.utils.NetworkUtils;
import com.mz.weather.viewmodel.WeatherViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private WeatherAdapter weatherAdapter;
    RecyclerView rv_weather ;
    TextView no_weather;
    public List<ResponseWeather> responseWeatherList = new ArrayList<>();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // change app title
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            setTitle("Tempo");
        }

        // initialization
        context = this;
        rv_weather = findViewById(R.id.rv_wheather);
        no_weather = findViewById(R.id.tv_empty_weather);
        boolean netWorkAvailable = NetworkUtils.isNetWorkAvailable(context);

        WeatherViewModel weatherViewModel = new WeatherViewModel();
        weatherViewModel.getCurrentWeather().observe(this, responseWeather -> {
            responseWeatherList.add(responseWeather);
            weatherAdapter = new WeatherAdapter(context, responseWeatherList);
            if (netWorkAvailable){
                setRecyclerView();
                no_weather.setVisibility(View.GONE);
            }else {
                no_weather.setText("Verifica a conexão com a internet");
                no_weather.setVisibility(View.VISIBLE);
            }

        });
    }

    private void setRecyclerView(){
        // set list layout style grid
        rv_weather.setLayoutManager(new GridLayoutManager(context, 2) );
        rv_weather.setAdapter(weatherAdapter);
        weatherAdapter.notifyDataSetChanged();
    }

}