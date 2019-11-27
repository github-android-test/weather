package com.bojanpavlovic.weather.model;

import com.google.gson.annotations.SerializedName;

public class WindModel {
    @SerializedName("speed")
    private float speed;
    @SerializedName("deg")
    private float degrees;

    public float getSpeed(){
        return speed;
    }

    public float getDegrees(){
        return degrees;
    }

}
