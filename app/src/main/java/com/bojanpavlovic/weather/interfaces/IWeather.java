package com.bojanpavlovic.weather.interfaces;


import com.bojanpavlovic.weather.model.CurrentWeatherModel;
import com.bojanpavlovic.weather.model.ForecastWeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IWeather {
    // Defines all possible calls to OpenWeatherMap REST API

    @GET("data/2.5/weather")
    Call<CurrentWeatherModel> getCurrentWeather(@Query("q") String city, @Query("appid") String appId);
    @GET("data/2.5/forecast")
    Call<ForecastWeatherModel> getForecastWeather(@Query("q") String city, @Query("appid") String appId);

}
