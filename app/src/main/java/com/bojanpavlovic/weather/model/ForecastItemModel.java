package com.bojanpavlovic.weather.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastItemModel {
    @SerializedName("dt")
    private long timestamp;
    @SerializedName("main")
    private ForecastMainModel mainModel;
    @SerializedName("weather")
    private List<WeatherItemModel> weatherList;
    @SerializedName("clouds")
    private CloudsModel clouds;
    @SerializedName("wind")
    private WindModel wind;
    @SerializedName("sys")
    private ForecastSysModel sysModel;
    @SerializedName("dt_txt")
    private String dateText;

    public long getTimestamp(){
        return timestamp;
    }

    public ForecastMainModel getMainModel(){
        return mainModel;
    }

    public List<WeatherItemModel> getWeatherList(){
        return weatherList;
    }

    public CloudsModel getClouds(){
        return clouds;
    }

    public WindModel getWind(){
        return wind;
    }

    public ForecastSysModel getSysModel(){
        return sysModel;
    }

    public String getDateText(){
        return dateText;
    }

}
