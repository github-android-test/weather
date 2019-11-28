package com.bojanpavlovic.weather.view;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bojanpavlovic.weather.ForecastRecyclerViewAdapter;
import com.bojanpavlovic.weather.R;
import com.bojanpavlovic.weather.model.ExtractedForecastDayData;
import com.bojanpavlovic.weather.model.ForecastWeatherModel;
import com.bojanpavlovic.weather.utils.ForecastUtil;
import com.bojanpavlovic.weather.viewmodel.ForecastWeatherViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastWeatherFragment extends Fragment {
    private ForecastWeatherViewModel forecastWeatherViewModel;
    private RecyclerView forecastRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ForecastRecyclerViewAdapter adapter;
    private List<ExtractedForecastDayData> forecastDataList;

    public ForecastWeatherFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("WEATHER_LOG", "ForecastWeatherFragment->onCreate()");
        forecastWeatherViewModel = ViewModelProviders.of(this).get(ForecastWeatherViewModel.class);
        forecastWeatherViewModel.getForecastWeather().observe(this, new Observer<ForecastWeatherModel>() {
            @Override
            public void onChanged(ForecastWeatherModel forecastWeatherModel) {
                // Update UI !!!
                Log.i("WEATHER_LOG", "ForecastWeatherFragment->onChanged()");
                // TODO Convert temp to proper unit
                // TODO Get min max temps for 5 days
                // TODO Show to GUI
                updateUI(forecastWeatherModel);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.fragment_forecast_weather, container, false);
        initUI(inflatedView);
        return inflatedView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("WEATHER_LOG", "ForecastWeatherFragment->onViewCreated()");
        // TODO Add implementation here !!!
    }

    private void initUI(View inflatedView){
        Log.i("WEATHER_LOG", "ForecastWeatherFragment->initUI()");
        // TODO Add implementation here !!!
        forecastRecyclerView = inflatedView.findViewById(R.id.forecast_recycler_view);
        forecastRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getContext());
        forecastRecyclerView.setLayoutManager(layoutManager);
        adapter = new ForecastRecyclerViewAdapter();
        forecastRecyclerView.setAdapter(adapter);
        forecastDataList = new ArrayList<>();
    }

    private void updateUI(ForecastWeatherModel forecastWeatherModel){
        Log.i("WEATHER_LOG", "ForecastWeatherFragment->updateUI()");
        forecastDataList = ForecastUtil.extractForecastData(forecastWeatherModel);
        adapter.setData(forecastDataList);
    }


}
