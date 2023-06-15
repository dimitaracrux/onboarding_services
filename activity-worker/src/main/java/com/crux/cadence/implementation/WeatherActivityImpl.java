package com.crux.cadence.implementation;

import com.crux.cadence.activity.WeatherActivity;
import com.crux.cadence.model.WeatherInfo;

public class WeatherActivityImpl implements WeatherActivity {
    @Override
    public WeatherInfo getWeatherInfo(String city) {
        // call weather API
        return new WeatherInfo("sunny", 26, city);
    }

    @Override
    public void storeWeatherInfo(WeatherInfo weatherInfo) {
        // store weatherInfo to DB
        System.out.println("store this row for city " + weatherInfo.getCity() + " " + weatherInfo.getWeather() + " " +
                weatherInfo.getDegrees());
    }
}
