package com.bojanpavlovic.weather.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.bojanpavlovic.weather.R;
import com.bojanpavlovic.weather.interfaces.IWeatherService;
import com.bojanpavlovic.weather.model.CurrentWeatherModel;
import com.bojanpavlovic.weather.model.ForecastWeatherModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    CurrentWeatherFragment currentWeatherFragment;
    ForecastWeatherFragment forecastWeatherFragment;
    SettingsFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        setupViewPager(viewPager);
        setBottomNavigationBehaviour(bottomNavigationView, viewPager);
        setViewPagerBehaviour(bottomNavigationView, viewPager);

        //================================
        // TODO Remove later, just for test
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.API_BASE_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IWeatherService weatherService = retrofit.create(IWeatherService.class);

        Call<CurrentWeatherModel> call = weatherService.getCurrentWeather("Nis", getString(R.string.APP_ID));
        call.enqueue(new Callback<CurrentWeatherModel>() {
            @Override
            public void onResponse(Call<CurrentWeatherModel> call, Response<CurrentWeatherModel> response) {

            }

            @Override
            public void onFailure(Call<CurrentWeatherModel> call, Throwable t) {

            }
        });

//        Call<ForecastWeatherModel> call = weatherService.getForecastWeather("Nis", getString(R.string.APP_ID));
//        call.enqueue(new Callback<ForecastWeatherModel>() {
//            @Override
//            public void onResponse(Call<ForecastWeatherModel> call, Response<ForecastWeatherModel> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<ForecastWeatherModel> call, Throwable t) {
//
//            }
//        });

        //================================




    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        currentWeatherFragment = new CurrentWeatherFragment();
        forecastWeatherFragment = new ForecastWeatherFragment();
        settingsFragment = new SettingsFragment();
        viewPagerAdapter.addFragment(currentWeatherFragment);
        viewPagerAdapter.addFragment(forecastWeatherFragment);
        viewPagerAdapter.addFragment(settingsFragment);
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void setBottomNavigationBehaviour(BottomNavigationView bottomNavigationView, final ViewPager viewPager){
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.bottom_navigation_item_weather:
                        Log.i("WEATHER_LOG", "onNavigationItemSelected 0");
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.bottom_navigation_item_forecast:
                        Log.i("WEATHER_LOG", "onNavigationItemSelected 1");
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.bottom_navigation_item_settings:
                        Log.i("WEATHER_LOG", "onNavigationItemSelected 2");
                        viewPager.setCurrentItem(2);
                        return true;
                }
                return false;
            }
        });
    }

    private void setViewPagerBehaviour(final BottomNavigationView bottomNavigationView, ViewPager viewPager){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(0).setChecked(false);
                bottomNavigationView.getMenu().getItem(1).setChecked(false);
                bottomNavigationView.getMenu().getItem(2).setChecked(false);
                switch (position){
                    // Todo Implement function to uncheck all menu items first
                    case 0:
                        Log.i("WEATHER_LOG", "onPageSelected 0");
                        bottomNavigationView.getMenu().getItem(0).setChecked(true);
                        break;
                    case 1:
                        Log.i("WEATHER_LOG", "onPageSelected 1");
                        bottomNavigationView.getMenu().getItem(1).setChecked(true);
                        break;
                    case 2:
                        Log.i("WEATHER_LOG", "onPageSelected 2");
                        bottomNavigationView.getMenu().getItem(2).setChecked(true);
                        break;
                    default:
                        Log.i("WEATHER_LOG", "onPageSelected DEFAULT");

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }




}
