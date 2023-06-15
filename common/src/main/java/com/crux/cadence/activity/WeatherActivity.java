package com.crux.cadence.activity;


import com.crux.cadence.model.WeatherInfo;
import com.uber.cadence.activity.ActivityMethod;

public interface WeatherActivity {
    @ActivityMethod
    WeatherInfo getWeatherInfo(String city);

    @ActivityMethod
    void storeWeatherInfo(WeatherInfo weatherInfo);
}
