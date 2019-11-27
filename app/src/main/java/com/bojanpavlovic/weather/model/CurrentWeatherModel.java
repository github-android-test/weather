package com.bojanpavlovic.weather.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentWeatherModel {
    // http://api.openweathermap.org/data/2.5/weather?q=nis&appid=da9fcd4c6893eb6029fae2169a6b283d
    @SerializedName("coord")
    private CoordinatesModel coord;
    @SerializedName("weather")
    private List<WeatherItemModel> weatherList;
    @SerializedName("base")
    private String base;
    @SerializedName("main")
    private MainDataModel mainDataModel;
    @SerializedName("visibility")
    private int visibility;
    @SerializedName("wind")
    private WindModel wind;
    @SerializedName("clouds")
    private CloudsModel clouds;
    @SerializedName("dt")
    private long timestamp;
    @SerializedName("sys")
    private SysModel sysModel;
    @SerializedName("timezone")
    private int timezone;
    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("cod")
    private int code;

    public CoordinatesModel getCoordinates(){
        return coord;
    }

    public List<WeatherItemModel> getWeatherList(){
        return weatherList;
    }

    public String getBase(){
        return base;
    }

    public MainDataModel getMainDataModel(){
        return mainDataModel;
    }

    public int getVisibility(){
        return visibility;
    }

    public WindModel getWind(){
        return wind;
    }

    public CloudsModel getClouds(){
        return clouds;
    }

    public long getTimestamp(){
        return timestamp;
    }

    public SysModel getSysModel(){
        return sysModel;
    }

    public int getTimezone(){
        return timezone;
    }

    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getCode(){
        return code;
    }

}

