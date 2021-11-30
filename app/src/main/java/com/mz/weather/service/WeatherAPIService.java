package com.mz.weather.service;

import com.mz.weather.model.ResponseWeather;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPIService {
    @GET("/data/2.5/weather?&appid=6b7fb460503b8e1af85c00d04ab82e31&&units=metric&lang=pt")
    Call<ResponseWeather> getWeather(@Query("q") String city);
}
