package com.bojanpavlovic.weather.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;


import com.bojanpavlovic.weather.model.DataRepository;
import com.bojanpavlovic.weather.model.ForecastWeatherModel;

public class ForecastWeatherViewModel extends AndroidViewModel {
    private MutableLiveData<ForecastWeatherModel> forecastWeatherModelMutableLiveData;

    public ForecastWeatherViewModel(@NonNull Application application) {
        super(application);
        Log.i("WEATHER_LOG", "ForecastWeatherViewModel->ForecastWeatherViewModel()");
    }

    public  MutableLiveData<ForecastWeatherModel> getForecastWeather(){
        Log.i("WEATHER_LOG", "ForecastWeatherViewModel->getForecastWeather()");
        if(forecastWeatherModelMutableLiveData == null)
            forecastWeatherModelMutableLiveData = loadForecastWeatherData();
        return forecastWeatherModelMutableLiveData;
    }

    private MutableLiveData<ForecastWeatherModel> loadForecastWeatherData(){
        // Call Data layer !!!
        Log.i("WEATHER_LOG", "ForecastWeatherViewModel->loadForecastWeatherData()");
        return DataRepository.getINSTANCE(getApplication()).getForecastWeatherModelMutableLiveData(getApplication());
    }

}
