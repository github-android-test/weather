package com.bojanpavlovic.weather.model;

import com.google.gson.annotations.SerializedName;

public class SysModel {
    @SerializedName("type")
    private int type;
    @SerializedName("id")
    private int id;
    @SerializedName("country")
    private String country;
    @SerializedName("sunrise")
    private long sunriseTimestamp;
    @SerializedName("sunset")
    private long sunsetTimestamp;

    public int getType(){
        return type;
    }

    public int getId(){
        return id;
    }

    public String getCountry(){
        return country;
    }

    public long getSunriseTimestamp(){
        return sunriseTimestamp;
    }

    public long getSunsetTimestamp(){
        return sunsetTimestamp;
    }

}
