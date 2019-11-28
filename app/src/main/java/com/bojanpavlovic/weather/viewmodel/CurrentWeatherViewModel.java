package com.bojanpavlovic.weather.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.bojanpavlovic.weather.model.CurrentWeatherModel;
import com.bojanpavlovic.weather.model.DataRepository;

public class CurrentWeatherViewModel extends AndroidViewModel {
    private MutableLiveData<CurrentWeatherModel> currentWeather;

    public CurrentWeatherViewModel(@NonNull Application application) {
        super(application);
        Log.i("WEATHER_LOG", "CurrentWeatherViewModel->CurrentWeatherViewModel()");
    }

    public  MutableLiveData<CurrentWeatherModel> getCurrentWeather(){
        Log.i("WEATHER_LOG", "CurrentWeatherViewModel->getCurrentWeather()");
        if(currentWeather == null)
            currentWeather = loadCurrentWeatherData();
        return currentWeather;
    }

    private MutableLiveData<CurrentWeatherModel> loadCurrentWeatherData(){
        // Call Data layer !!!
        Log.i("WEATHER_LOG", "CurrentWeatherViewModel->loadCurrentWeatherData()");
        return DataRepository.getINSTANCE(getApplication()).getCurrentWeatherModelMutableLiveData(getApplication());
    }

}
