package com.bojanpavlovic.weather.model;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.bojanpavlovic.weather.R;
import com.bojanpavlovic.weather.interfaces.IWeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataRepository {
    private static DataRepository INSTANCE = null;
    IWeatherService weatherService;
    private MutableLiveData<CurrentWeatherModel> currentWeatherModelMutableLiveData;
    private MutableLiveData<ForecastWeatherModel> forecastWeatherModelMutableLiveData;

    private DataRepository(Context context){
        Log.i("WEATHER_LOG", "DataRepository->DataRepository()");
        initRetrofit(context);
        currentWeatherModelMutableLiveData = new MutableLiveData<>();
        forecastWeatherModelMutableLiveData = new MutableLiveData<>();
    }

    public static DataRepository getINSTANCE(Context context){
        Log.i("WEATHER_LOG", "DataRepository->getINSTANCE()");
        if(INSTANCE == null)
            INSTANCE = new DataRepository(context);
        return INSTANCE;
    }

    private void initRetrofit(Context context){
        Log.i("WEATHER_LOG", "DataRepository->initRetrofit()");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.API_BASE_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        weatherService = retrofit.create(IWeatherService.class);
    }

    public MutableLiveData<CurrentWeatherModel> getCurrentWeatherModelMutableLiveData(Context context){
        Log.i("WEATHER_LOG", "DataRepository->getCurrentWeatherModelMutableLiveData()");
        Call<CurrentWeatherModel> call = weatherService.getCurrentWeather("Nis", context.getString(R.string.APP_ID));
        call.enqueue(new Callback<CurrentWeatherModel>() {
            @Override
            public void onResponse(Call<CurrentWeatherModel> call, Response<CurrentWeatherModel> response) {
                Log.i("WEATHER_LOG", "DataRepository->getCurrentWeatherModelMutableLiveData():onResponse");
                currentWeatherModelMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<CurrentWeatherModel> call, Throwable t) {
                Log.i("WEATHER_LOG", "DataRepository->getCurrentWeatherModelMutableLiveData():onFailure");
                // TODO Handle errors !!!
            }
        });

        return currentWeatherModelMutableLiveData;
    }

    public MutableLiveData<ForecastWeatherModel> getForecastWeatherModelMutableLiveData(Context context){
        Log.i("WEATHER_LOG", "DataRepository->getForecastWeatherModelMutableLiveData");
        Call<ForecastWeatherModel> call = weatherService.getForecastWeather("Nis", context.getString(R.string.APP_ID));
        call.enqueue(new Callback<ForecastWeatherModel>() {
            @Override
            public void onResponse(Call<ForecastWeatherModel> call, Response<ForecastWeatherModel> response) {
                Log.i("WEATHER_LOG", "DataRepository->getForecastWeatherModelMutableLiveData():onResponse");
                forecastWeatherModelMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ForecastWeatherModel> call, Throwable t) {
                Log.i("WEATHER_LOG", "DataRepository->getForecastWeatherModelMutableLiveData():onFailure");
                // TODO Handle errors !!!
            }
        });

        return forecastWeatherModelMutableLiveData;
    }

}
