package com.bojanpavlovic.weather.model;

import com.google.gson.annotations.SerializedName;

public class MainDataModel {
    @SerializedName("temp")
    private float temp;
    @SerializedName("pressure")
    private int pressure;
    @SerializedName("humidity")
    private int humidity;
    @SerializedName("temp_min")
    private float minTemp;
    @SerializedName("temp_max")
    private float maxTemp;

    public float getTemp(){
        return temp;
    }

    public int getPressure(){
        return pressure;
    }

    private int getHumidity(){
        return humidity;
    }

    private float getMinTemp(){
        return minTemp;
    }

    private float getMaxTemp(){
        return maxTemp;
    }

}
