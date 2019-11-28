package com.bojanpavlovic.weather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bojanpavlovic.weather.model.ExtractedForecastDayData;
import com.bojanpavlovic.weather.utils.ForecastUtil;
import com.bojanpavlovic.weather.utils.TemperatureConvertorUtil;

import java.util.ArrayList;
import java.util.List;

public class ForecastRecyclerViewAdapter extends RecyclerView.Adapter<ForecastRecyclerViewAdapter.CustomViewHolder> {
    private List<ExtractedForecastDayData> forecastDataList;

    public ForecastRecyclerViewAdapter(){
        forecastDataList = new ArrayList<>();
    }

    public void setData(List<ExtractedForecastDayData> forecastDataList){
        this.forecastDataList = forecastDataList;
        notifyDataSetChanged();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView dateTextView;
        TextView minTempTextView;
        TextView maxTempTextView;

        CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.date);
            minTempTextView = itemView.findViewById(R.id.min_temp);
            maxTempTextView = itemView.findViewById(R.id.max_temp);
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_item, parent, false);
        return new CustomViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.dateTextView.setText(ForecastUtil.getFormattedDate(forecastDataList.get(position).getTimestampInSeconds()));
        String minTempInCelsius = TemperatureConvertorUtil.convertToCelsiusText(forecastDataList.get(position).getMinTemp());
        String maxTempInCelsius = TemperatureConvertorUtil.convertToCelsiusText(forecastDataList.get(position).getMaxTemp());
        holder.minTempTextView.setText(minTempInCelsius);
        holder.maxTempTextView.setText(maxTempInCelsius);
    }

    @Override
    public int getItemCount() {
        return forecastDataList != null ? forecastDataList.size() : 0;
    }

}
