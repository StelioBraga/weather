package com.mz.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.chip.Chip;
import com.mz.weather.model.ResponseWeather;
import com.mz.weather.service.OpenImge;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DetailsActivity extends AppCompatActivity {
    TextView tv_location, tv_date, tv_temperature, tv_temperature_max, tv_temperature_min, tv_humidity, tv_pressure, tv_wind_speed, tv_sun;
    ImageView iv_state;
    Chip chip_weather_state;
    String photo_url_str = "http://openweathermap.org/img/wn/02d@2x.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // inicialization
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


        ResponseWeather responseWeather = (ResponseWeather) getIntent().getSerializableExtra("weather");
        if (responseWeather != null) {
            tv_location.setText(responseWeather.getCity() + ", " + responseWeather.getSys().getCountry());
            tv_temperature.setText(String.valueOf(Math.round(responseWeather.getMain().getTemp()) + "\u2103"));
            tv_temperature_max.setText(String.valueOf(Math.round(responseWeather.getMain().getTemp_max()) + "\u2103"));
            tv_temperature_min.setText(String.valueOf(Math.round(responseWeather.getMain().getTemp_min()) + "\u2103"));
            tv_humidity.setText(String.valueOf(responseWeather.getMain().getHumidity() + "%"));
            tv_pressure.setText(String.valueOf(responseWeather.getMain().getPressure()));
            tv_wind_speed.setText(String.valueOf(responseWeather.getWind().getSpeed() + "km/h"));
            chip_weather_state.setText(responseWeather.getWeather().get(0).getDescription());
            new OpenImge(photo_url_str, iv_state);
            String sunrise =  convertDate(responseWeather.getSys().getSunrise());
            String sunset =  convertDate(responseWeather.getSys().getSunset());
            String sun = sunrise +"/"+ sunset;
            tv_sun.setText(sun);
        }


    }

    public String convertDate(long currentTime){
        String time = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(currentTime));


        return  time;
    }

}