package com.bojanpavlovic.weather.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bojanpavlovic.weather.TempUnit;
import com.bojanpavlovic.weather.model.ForecastWeatherModel;
import com.bojanpavlovic.weather.repository.Repository;

public class ForecastWeatherViewModel extends AndroidViewModel {
    private MutableLiveData<ForecastWeatherModel> forecastWeatherModelMutableLiveData;
    private MutableLiveData<TempUnit> measureUnit;

    public ForecastWeatherViewModel(@NonNull Application application) {
        super(application);
        // Default temp unit is Celsius
        measureUnit = new MutableLiveData<>();
        measureUnit.postValue(TempUnit.CELSIUS);
    }

    private MutableLiveData<ForecastWeatherModel> loadForecastWeatherData(){
        // TODO Implement strategy for selecting data source(Web or Room) here !!!
        // Call to Repository layer !!!
        // Get temperature in proper unit <measureUnit>
        return Repository.getINSTANCE(getApplication()).getForecastWeather(getApplication());
    }

    // ViewModel API for exposing to View
    public  MutableLiveData<ForecastWeatherModel> getForecastWeather(){
        if(forecastWeatherModelMutableLiveData == null)
            forecastWeatherModelMutableLiveData = loadForecastWeatherData();
        return forecastWeatherModelMutableLiveData;
    }

    public void setTempUnit(TempUnit unit){
        measureUnit.setValue(unit);
    }

    public LiveData<TempUnit> getTempUnit(){
        return measureUnit;
    }

}
