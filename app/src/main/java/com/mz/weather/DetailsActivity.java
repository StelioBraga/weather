package com.mz.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.chip.Chip;
import com.mz.weather.model.ResponseWeather;
import com.mz.weather.utils.GetWeatherIcon;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class DetailsActivity extends AppCompatActivity {
    TextView tv_location, tv_date, tv_temperature, tv_temperature_max, tv_temperature_min, tv_humidity, tv_pressure, tv_wind_speed, tv_sun;
    ImageView iv_state;
    Chip chip_weather_state;
    private String hourFormat = "HH:mm:ss";
    private String dayFormat = "dd/MM/yy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // change app title
        Objects.requireNonNull(getSupportActionBar()).setTitle("Detalhes");

        // initialization
        tv_location = findViewById(R.id.tv_location);
        tv_temperature = findViewById(R.id.tv_temperature_state);
        tv_temperature_max = findViewById(R.id.tv_temperature_max);
        tv_temperature_min = findViewById(R.id.tv_temperature_min);
        tv_humidity = findViewById(R.id.tv_humidity_state);
        tv_pressure = findViewById(R.id.tv_pressure_state);
        tv_wind_speed = findViewById(R.id.tv_speed_state);
        tv_date =  findViewById(R.id.tv_date);
        chip_weather_state = findViewById(R.id.chip_weather_state);
        iv_state = findViewById(R.id.iv_weather_state);
        tv_sun = findViewById(R.id.tv_sun);

        //get data from old screen
        ResponseWeather  responseWeather = (ResponseWeather) getIntent().getSerializableExtra("weather");
        getWeatherDetails(responseWeather);
    }

    public void getWeatherDetails(ResponseWeather responseWeather){
        //check if weather exists
        if (responseWeather != null) {
            String location  = responseWeather.getCity() + ", " + responseWeather.getSys().getCountry();
            String temperature = Math.round(responseWeather.getMain().getTemp()) + getResources().getString(R.string.degree);
            String temperatureMax = Math.round(responseWeather.getMain().getTemp_max()) + getResources().getString(R.string.degree);
            String temperatureMin = Math.round(responseWeather.getMain().getTemp_min()) + getResources().getString(R.string.celsius);
            String humidity = responseWeather.getMain().getHumidity() + getResources().getString(R.string.pressure);
            String pressure = responseWeather.getMain().getPressure() + getResources().getString(R.string.pressure);
            String wind = responseWeather.getWind().getSpeed() + getResources().getString(R.string.speed_kilometre);
            String description = responseWeather.getWeather().get(0).getDescription();
            String day = convertDate(responseWeather.getDt(),dayFormat);
            String sunrise =  convertDate(responseWeather.getSys().getSunrise(),hourFormat);
            String sunset =  convertDate(responseWeather.getSys().getSunset(),hourFormat);
            String sun = sunrise +"/"+ sunset;
            String icon = responseWeather.getWeather().get(0).getIcon();

            tv_location.setText(location);
            tv_temperature.setText(temperature);
            tv_temperature_max.setText(temperatureMax);
            tv_temperature_min.setText(temperatureMin);
            tv_humidity.setText(humidity);
            tv_pressure.setText(pressure);
            tv_wind_speed.setText(wind);
            chip_weather_state.setText(description);
            tv_date.setText(day);
            tv_sun.setText(sun);
            new GetWeatherIcon(this,icon,iv_state);
        }

    }

    // convert the timestamp
    public String convertDate(long currentTime, String timeFormat){
        int milliseconds = 1000;
        Date date = new Date(currentTime * milliseconds);
        String time = new SimpleDateFormat(timeFormat, Locale.getDefault()).format(date);
        return time;
    }


}