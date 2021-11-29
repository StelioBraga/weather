package com.mz.weather.model;

import java.util.Date;

public class Weatherss {
    private int temperature;
    private String city;
    private String country;
    private int wind_speed;
    private int clouds;
    private int humidity;
    private int pressure;
    private int wheather_icon;
    private Date timezone;

    public Weatherss(int temperature, String city, String country, int wind_speed, int clouds, int humidity, int pressure, int wheather_icon, Date timezone) {
        this.temperature = temperature;
        this.city = city;
        this.country = country;
        this.wind_speed = wind_speed;
        this.clouds = clouds;
        this.humidity = humidity;
        this.pressure = pressure;
        this.wheather_icon = wheather_icon;
        this.timezone = timezone;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(int wind_speed) {
        this.wind_speed = wind_speed;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getWheather_icon() {
        return wheather_icon;
    }

    public void setWheather_icon(int wheather_icon) {
        this.wheather_icon = wheather_icon;
    }

    public Date getTimezone() {
        return timezone;
    }

    public void setTimezone(Date timezone) {
        this.timezone = timezone;
    }
}
