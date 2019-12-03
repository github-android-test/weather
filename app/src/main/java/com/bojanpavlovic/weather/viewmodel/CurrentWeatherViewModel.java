package com.bojanpavlovic.weather.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.bojanpavlovic.weather.TempUnit;
import com.bojanpavlovic.weather.model.CurrentWeatherModel;
import com.bojanpavlovic.weather.repository.Repository;

public class CurrentWeatherViewModel extends AndroidViewModel {
    private MutableLiveData<CurrentWeatherModel> currentWeather;
    private MutableLiveData<TempUnit> measureUnit;

    public CurrentWeatherViewModel(@NonNull Application application) {
        super(application);
        // Default temp unit is Celsius
        measureUnit = new MutableLiveData<>();
        measureUnit.postValue(TempUnit.CELSIUS);
    }

    public  MutableLiveData<CurrentWeatherModel> getCurrentWeather(){
        if(currentWeather == null)
            currentWeather = loadCurrentWeatherData();
        return currentWeather;
    }

    private MutableLiveData<CurrentWeatherModel> loadCurrentWeatherData(){
        // TODO Implement strategy for selecting data source(Web or Room) here !!!
        // Call to Repository layer
        // Get temperature in proper unit <measureUnit>
        return Repository.getINSTANCE(getApplication()).getCurrentWeather(getApplication());
    }

}
