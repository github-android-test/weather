package com.bojanpavlovic.weather.utils;

public class TemperatureConvertorUtil {
    // Util used for converting Celsius to Kelvin and vice versa

    public static String convertToCelsiusText(int temperatureInKelvin){
        float temp = temperatureInKelvin - 273.15f;
        temp = Math.round(temp);
        return String.valueOf((int)temp);
    }

    public static String convertToKelvinText(int temperatureInCelsius){
        float temp = temperatureInCelsius + 273.15f;
        temp = Math.round(temp);
        return String.valueOf((int)temp);
    }

}
