package com.bojanpavlovic.weather.model;

import com.google.gson.annotations.SerializedName;

public class WeatherItemModel {
    @SerializedName("id")
    private int id;
    @SerializedName("main")
    private String main;
    @SerializedName("description")
    private String description;
    @SerializedName("icon")
    private String iconId;

    public int getId(){
        return id;
    }

    public String getMain(){
        return main;
    }

    public String getDescription(){
        return description;
    }

    public String getIconId(){
        return iconId;
    }

}
