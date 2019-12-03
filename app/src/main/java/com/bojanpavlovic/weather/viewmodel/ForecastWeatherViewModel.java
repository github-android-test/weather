package com.bojanpavlovic.weather.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.bojanpavlovic.weather.model.ForecastWeatherModel;
import com.bojanpavlovic.weather.repository.Repository;

public class ForecastWeatherViewModel extends AndroidViewModel {
    private MutableLiveData<ForecastWeatherModel> forecastWeatherModelMutableLiveData;

    public ForecastWeatherViewModel(@NonNull Application application) {
        super(application);
    }

    public  MutableLiveData<ForecastWeatherModel> getForecastWeather(){
        if(forecastWeatherModelMutableLiveData == null)
            forecastWeatherModelMutableLiveData = loadForecastWeatherData();
        return forecastWeatherModelMutableLiveData;
    }

    private MutableLiveData<ForecastWeatherModel> loadForecastWeatherData(){
        // TODO Implement strategy for selecting data source(Web or Room) here !!!
        // Call to Repository layer !!!
        return Repository.getINSTANCE(getApplication()).getForecastWeather(getApplication());
    }

}
