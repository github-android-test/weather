package com.bojanpavlovic.weather.model;

public class ExtractedForecastDayData {
    private String date;
    private int minTemp;
    private int maxTemp;
    private long timestampInSeconds;

    public ExtractedForecastDayData(String date, float minTemp, float maxTemp, long timestampInSeconds){
        this.date = date;
        this.minTemp = Math.round(minTemp);
        this.maxTemp = Math.round(maxTemp);
        this.timestampInSeconds = timestampInSeconds;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setMinTemp(float minTemp){
        this.minTemp = Math.round(minTemp);
    }

    public void setMaxTemp(float maxTemp){
        this.maxTemp = Math.round(maxTemp);
    }

    public void setTimestampInSeconds(long timestampInSeconds){
        this.timestampInSeconds = timestampInSeconds;
    }

    public String getDate(){
        return date;
    }

    public int getMinTemp(){
        return minTemp;
    }

    public int getMaxTemp(){
        return maxTemp;
    }

    public long getTimestampInSeconds(){
        return timestampInSeconds;
    }

}
