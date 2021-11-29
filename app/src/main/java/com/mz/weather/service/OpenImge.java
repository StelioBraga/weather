package com.mz.weather.service;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenImge extends AsyncTask<Void, Void, Bitmap> {
    private String imageUrl;
    private ImageView imageView;

    public OpenImge(String url, ImageView imageView) {
        this.imageUrl = url;
        this.imageView = imageView;
    }
    @Override
    protected Bitmap doInBackground(Void... params) {
        try {
            URL urlConnection = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) urlConnection
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);
            return myBitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        imageView.setImageBitmap(result);
    }
}
