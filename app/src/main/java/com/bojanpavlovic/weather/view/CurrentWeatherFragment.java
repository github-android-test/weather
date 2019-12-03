package com.bojanpavlovic.weather.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bojanpavlovic.weather.R;
import com.bojanpavlovic.weather.model.CurrentWeatherModel;
import com.bojanpavlovic.weather.utils.TemperatureConvertorUtil;
import com.bojanpavlovic.weather.viewmodel.CurrentWeatherViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentWeatherFragment extends Fragment {
    private CurrentWeatherViewModel weatherViewModel;
    private TextView tempTextView;
    private TextView cityTextView;
    private String temp = "--";
    private String city = "---";

    public CurrentWeatherFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weatherViewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel.class);
        weatherViewModel.getCurrentWeather().observe(this, new Observer<CurrentWeatherModel>() {
            @Override
            public void onChanged(CurrentWeatherModel currentWeatherModel) {
                // Update UI !!!
                updateUI(currentWeatherModel);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.fragment_current_weather, container, false);
        initUI(inflatedView);
        return inflatedView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tempTextView.setText(temp);
        cityTextView.setText(city);
    }

    private void initUI(View inflatedView){
        tempTextView = inflatedView.findViewById(R.id.temperature);
        cityTextView = inflatedView.findViewById(R.id.city);
    }

    private void updateUI(CurrentWeatherModel currentWeatherModel){
        float tempAsFloat = currentWeatherModel.getMainDataModel().getTemp();
        temp = TemperatureConvertorUtil.convertToCelsiusText((int)tempAsFloat);
        city = currentWeatherModel.getName();
        tempTextView.setText(temp);
        cityTextView.setText(city);
    }

}
