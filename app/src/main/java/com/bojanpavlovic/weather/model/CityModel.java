package com.bojanpavlovic.weather.model;

import com.google.gson.annotations.SerializedName;

public class CityModel {
    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("coord")
    private CoordinatesModel coordinates;
    @SerializedName("country")
    private String country;
    @SerializedName("population")
    private int population;
    @SerializedName("timezone")
    private int timezone;
    @SerializedName("sunrise")
    private long sunrise;
    @SerializedName("sunset")
    private long sunset;

    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public CoordinatesModel getCoordinates(){
        return coordinates;
    }

    public String getCountry(){
        return country;
    }

    public int getPopulation(){
        return population;
    }

    public int getTimezone(){
        return timezone;
    }

    public long getSunrise(){
        return sunrise;
    }

    public long getSunset(){
        return sunset;
    }

}
