package com.bojanpavlovic.weather.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bojanpavlovic.weather.R;
import com.bojanpavlovic.weather.interfaces.IWeatherService;
import com.bojanpavlovic.weather.model.CurrentWeatherModel;
import com.bojanpavlovic.weather.model.ForecastWeatherModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //================================
        // TODO Remove later, just for test
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.API_BASE_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IWeatherService weatherService = retrofit.create(IWeatherService.class);

        Call<CurrentWeatherModel> call = weatherService.getCurrentWeather("Nis", getString(R.string.APP_ID));
        call.enqueue(new Callback<CurrentWeatherModel>() {
            @Override
            public void onResponse(Call<CurrentWeatherModel> call, Response<CurrentWeatherModel> response) {

            }

            @Override
            public void onFailure(Call<CurrentWeatherModel> call, Throwable t) {

            }
        });

//        Call<ForecastWeatherModel> call = weatherService.getForecastWeather("Nis", getString(R.string.APP_ID));
//        call.enqueue(new Callback<ForecastWeatherModel>() {
//            @Override
//            public void onResponse(Call<ForecastWeatherModel> call, Response<ForecastWeatherModel> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<ForecastWeatherModel> call, Throwable t) {
//
//            }
//        });

        //================================









    }
}
