package com.bojanpavlovic.weather.model;

import com.google.gson.annotations.SerializedName;

public class ForecastSysModel {
    @SerializedName("pod")
    private String pod;

    public String getPod(){
        return pod;
    }

}
