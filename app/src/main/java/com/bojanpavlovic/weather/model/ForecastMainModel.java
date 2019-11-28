package com.bojanpavlovic.weather.model;

import com.google.gson.annotations.SerializedName;

public class ForecastMainModel extends MainDataModel {
    @SerializedName("sea_level")
    private int seaLevel;
    @SerializedName("grnd_level")
    private int groundLevel;
    @SerializedName("temp_kf")
    private float tempKf;

    public int getSeaLevel(){
        return seaLevel;
    }

    public int getGroundLevel(){
        return groundLevel;
    }

    public float getTempKf(){
        return tempKf;
    }

}
