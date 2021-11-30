package com.mz.weather.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResponseWeather implements Serializable {
    @SerializedName("name")
    private String city;
    private long dt;
    Main main;
    Sys sys;
    List<Weather> weather;
    Wind wind;


    public ResponseWeather(String city,long date, Main main, Sys sys, List<Weather> weather, Wind wind) {
        this.city = city;
        this.dt = date;
        this.main = main;
        this.sys = sys;
        this.weather = weather;
        this.wind = wind;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public long getDt() {

        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }
}
