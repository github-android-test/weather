package com.bojanpavlovic.weather.model;

import com.google.gson.annotations.SerializedName;

public class CloudsModel {
    @SerializedName("all")
    private int cloudsType;

    public int getCloudsType(){
        return cloudsType;
    }

}
