package com.bojanpavlovic.weather.utils;

import com.bojanpavlovic.weather.model.ExtractedForecastDayData;
import com.bojanpavlovic.weather.model.ForecastItemModel;
import com.bojanpavlovic.weather.model.ForecastWeatherModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ForecastUtil {
    // Used for calculating min and max temperature on daily basis for 5 days

    public static List<ExtractedForecastDayData> extractForecastData(ForecastWeatherModel forecastWeatherModel){
        List<ExtractedForecastDayData> minMaxItemContainerList = new ArrayList<>();
        List<ForecastItemModel> items = forecastWeatherModel.getForecastList();
        float currentMin = 1000;
        float currentMax = -1000;
        String date = "";
        long timestampInSeconds = 0;
        int dayInMonth = 0;

        // Init first day
        dayInMonth = getDayInMonth(items.get(0).getTimestamp());

        for (int i = 0; i < items.size(); i++){
            // Calculate min and max temperatures grouped by days.
            int temp = getDayInMonth(items.get(i).getTimestamp());
            if(dayInMonth == temp){
                float min = items.get(i).getMainModel().getMinTemp();
                float max = items.get(i).getMainModel().getMaxTemp();
                date = items.get(i).getDateText();
                timestampInSeconds = items.get(i).getTimestamp();
                // If found new min temp
                if(currentMin > min)
                    currentMin = min;
                // If found new max temp
                if(currentMax < max)
                    currentMax = max;
            }else{
                // Set new day of month.
                dayInMonth = temp;
                // Add new element with average mina and max temp for previous day
                minMaxItemContainerList.add(new ExtractedForecastDayData(date, currentMin, currentMax, timestampInSeconds));
                // Reset current min and max to default
                currentMin = 1000;
                currentMax = -1000;
            }

        }

        return minMaxItemContainerList;

    }

    private static int getDayInMonth(long timeInSeconds){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeInSeconds * 1000);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static String getFormattedDate(long timestampInSeconds){
        Date date = new Date();
        date.setTime(timestampInSeconds * 1000);
//        String formattedDate=new SimpleDateFormat("MMM d, yyyy").format(date);
        String formattedDate = new SimpleDateFormat("dd/MM").format(date);
        return formattedDate;
    }



}
