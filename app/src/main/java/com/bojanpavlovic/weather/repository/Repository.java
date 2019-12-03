package com.bojanpavlovic.weather.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bojanpavlovic.weather.interfaces.IRepository;
import com.bojanpavlovic.weather.model.CurrentWeatherModel;
import com.bojanpavlovic.weather.model.ForecastWeatherModel;

public class Repository implements IRepository {
    private static Repository INSTANCE = null;
    private WebService webService;
    private DatabaseService databaseService;

    private Repository(Application application) {
        initWebservice(application);
        initDatabaseService(application);
    }

    public static Repository getINSTANCE(Application application) {
        if (INSTANCE == null)
            INSTANCE = new Repository(application);
        return INSTANCE;
    }

    @Override
    public void initWebservice(Application application) {
        webService = new WebService(application);
    }

    @Override
    public void initDatabaseService(Application application) {
        databaseService = new DatabaseService(application);
    }

    @Override
    public MutableLiveData<CurrentWeatherModel> getCurrentWeather(Application application) {
        // Fetch data from web
        return webService.getCurrentLiveData(application);
    }

    @Override
    public LiveData<CurrentWeatherModel> getCurrentWeatherCached(Application application) {
        // TODO Fetch cached data from Room database
        return null;
    }

    @Override
    public MutableLiveData<ForecastWeatherModel> getForecastWeather(Application application) {
        // Fetch data from web
        return webService.getForecastLiveData(application);
    }

    @Override
    public LiveData<ForecastWeatherModel> getForecastWeatherCached(Application application) {
        // TODO Fetch cached data from Room database
        return null;
    }

}
