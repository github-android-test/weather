package com.bojanpavlovic.weather.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.bojanpavlovic.weather.model.CurrentWeatherModel;
import com.bojanpavlovic.weather.repository.Repository;

public class CurrentWeatherViewModel extends AndroidViewModel {
    private MutableLiveData<CurrentWeatherModel> currentWeather;

    public CurrentWeatherViewModel(@NonNull Application application) {
        super(application);
    }

    public  MutableLiveData<CurrentWeatherModel> getCurrentWeather(){
        if(currentWeather == null)
            currentWeather = loadCurrentWeatherData();
        return currentWeather;
    }

    private MutableLiveData<CurrentWeatherModel> loadCurrentWeatherData(){
        // TODO Implement strategy for selecting data source(Web or Room) here !!!
        // Call to Repository layer
        return Repository.getINSTANCE(getApplication()).getCurrentWeather(getApplication());
    }

}
