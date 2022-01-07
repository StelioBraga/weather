package com.mz.weather.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GetWeatherIcon {
    String base_url_photo = "https://openweathermap.org/img/wn/";

    public  GetWeatherIcon(Context context, String icon, ImageView imageView){
        String url  = base_url_photo+icon+"@2x.png";
        Glide.with(context).load(url).into(imageView);
    }


}
