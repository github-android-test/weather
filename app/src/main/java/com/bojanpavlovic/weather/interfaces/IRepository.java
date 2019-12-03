package com.bojanpavlovic.weather.interfaces;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.bojanpavlovic.weather.TempUnit;
import com.bojanpavlovic.weather.model.CurrentWeatherModel;
import com.bojanpavlovic.weather.model.ForecastWeatherModel;

public interface IRepository {
    void initWebservice(Application application);
    void initDatabaseService(Application application);
    LiveData<CurrentWeatherModel> getCurrentWeather(Application application);
    LiveData<CurrentWeatherModel> getCurrentWeatherCached(Application application);
    LiveData<ForecastWeatherModel> getForecastWeather(Application application);
    LiveData<ForecastWeatherModel> getForecastWeatherCached(Application application);
}
