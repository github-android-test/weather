package com.bojanpavlovic.weather.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastWeatherModel {
    // http://api.openweathermap.org/data/2.5/forecast?q=nis&appid=da9fcd4c6893eb6029fae2169a6b283d

    @SerializedName("cod")
    private int code;
    @SerializedName("message")
    private int message;
    @SerializedName("cnt")
    private int cnt;
    @SerializedName("list")
    private List<ForecastItemModel> forecastList;
    @SerializedName("city")
    private CityModel cityModel;

    public int getCode(){
        return code;
    }

    public int getMessage(){
        return message;
    }

    public int getCnt(){
        return cnt;
    }

    public List<ForecastItemModel> getForecastList(){
        return forecastList;
    }

    public CityModel getCityModel(){
        return cityModel;
    }

}
