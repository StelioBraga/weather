package com.mz.weather.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mz.weather.model.ResponseWeather;

public class WeatherViewModel extends ViewModel {
    private WeatherRepository weatherRepository;
    private MutableLiveData<ResponseWeather> mutableLiveData;

    public WeatherViewModel() {
       weatherRepository = new WeatherRepository();
    }

    public LiveData<ResponseWeather> getCurrentWeather() {
        if (mutableLiveData == null){
            mutableLiveData = weatherRepository.getWeather();
        }
        return  mutableLiveData;
    }
}
