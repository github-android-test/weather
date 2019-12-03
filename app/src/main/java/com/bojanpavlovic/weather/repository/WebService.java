package com.bojanpavlovic.weather.repository;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bojanpavlovic.weather.R;
import com.bojanpavlovic.weather.TempUnit;
import com.bojanpavlovic.weather.interfaces.IWeather;
import com.bojanpavlovic.weather.model.CurrentWeatherModel;
import com.bojanpavlovic.weather.model.ForecastWeatherModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Used for fetching data from REST API
 */
public class WebService {
    private Retrofit retrofit;
    private IWeather weatherService;

    public WebService(Application application){
        initRetrofit(application);
        weatherService = retrofit.create(IWeather.class);
    }

    // Initialize Retrofit
    private void initRetrofit(Application application){
        retrofit = new Retrofit.Builder()
                .baseUrl(application.getString(R.string.API_BASE_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // Fetch today's weather data from REST
    public MutableLiveData<CurrentWeatherModel> getCurrentLiveData(Context context){
        final MutableLiveData<CurrentWeatherModel> currentLiveData = new MutableLiveData<>();
        // TODO ENABLE SELECTING OTHER CITIES !!!
        Call<CurrentWeatherModel> call = weatherService.getCurrentWeather("Nis", context.getString(R.string.APP_ID));
        call.enqueue(new Callback<CurrentWeatherModel>() {
            @Override
            public void onResponse(Call<CurrentWeatherModel> call, Response<CurrentWeatherModel> response) {
                currentLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<CurrentWeatherModel> call, Throwable t) {
                // TODO Handle errors !!!
            }
        });
        return currentLiveData;
    }

    // Fetch forecast weather data from REST
    public MutableLiveData<ForecastWeatherModel> getForecastLiveData(Context context){
        final MutableLiveData<ForecastWeatherModel> forecastLiveData = new MutableLiveData<>();

        Call<ForecastWeatherModel> call = weatherService.getForecastWeather("Nis", context.getString(R.string.APP_ID));
        call.enqueue(new Callback<ForecastWeatherModel>() {
            @Override
            public void onResponse(Call<ForecastWeatherModel> call, Response<ForecastWeatherModel> response) {
                forecastLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ForecastWeatherModel> call, Throwable t) {
                // TODO Handle errors !!!
            }
        });

        return forecastLiveData;
    }

}
