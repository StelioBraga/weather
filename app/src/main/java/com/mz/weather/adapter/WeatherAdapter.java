package com.mz.weather.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mz.weather.DetailsActivity;
import com.mz.weather.model.ResponseWeather;
import com.mz.weather.model.Weatherss;
import com.mz.weather.R;
import com.mz.weather.service.GetWeatherIcon;

import java.util.List;

public class WeatherAdapter  extends RecyclerView.Adapter<WeatherAdapter.AdapterWeatherViewholder> {
    private List<ResponseWeather> responseWeatherList;
    private Context context;

    public WeatherAdapter(Context context, List list){
        this.context = context;
        this.responseWeatherList = list;
    }
    @NonNull
    @Override
    public WeatherAdapter.AdapterWeatherViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.rv_wheather,parent,false);
        return new WeatherAdapter.AdapterWeatherViewholder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.AdapterWeatherViewholder holder, int position) {
        ResponseWeather responseWeather = responseWeatherList.get(position);
        holder.tv_temperature.setText(Math.round(responseWeather.getMain().getTemp()) + "\u00B0");
        holder.tv_humidity.setText(responseWeather.getMain().getHumidity() + "%");
        holder.tv_city.setText(responseWeather.getCity());
        holder.tv_country.setText(responseWeather.getSys().getCountry());
        holder.tv_wind_speed.setText(responseWeather.getWind().getSpeed() + "Km/h");
        String icon =  responseWeather.getWeather().get(0).getIcon();
        new  GetWeatherIcon(context,icon,holder.iv_weather_icon);

    }

    @Override
    public int getItemCount() {
        return responseWeatherList.size();
    }

    public class AdapterWeatherViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_temperature;
        TextView tv_humidity;
        TextView tv_city;
        TextView tv_country;
        TextView tv_wind_speed;
        ImageView iv_weather_icon;

        public AdapterWeatherViewholder(@NonNull View itemView, WeatherAdapter weatherAdapter) {
            super(itemView);
            tv_temperature = itemView.findViewById(R.id.tv_temperature);
            tv_humidity = itemView.findViewById(R.id.tv_humidity);
            tv_city = itemView.findViewById(R.id.tv_city);
            tv_country = itemView.findViewById(R.id.tv_country);
            tv_wind_speed = itemView.findViewById(R.id.tv_wind_speed);
            iv_weather_icon = itemView.findViewById(R.id.iv_weather);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        ResponseWeather weatherss = responseWeatherList.get(getAdapterPosition());
        context.startActivity(new Intent(context, DetailsActivity.class).putExtra("weather",weatherss));
        }
    }
}
