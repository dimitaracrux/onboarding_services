package com.crux.cadence.implementation;

import com.crux.cadence.activity.WeatherActivity;
import com.crux.cadence.model.WeatherInfo;
import com.crux.cadence.workflow.WeatherWorkflow;
import com.uber.cadence.activity.ActivityOptions;
import com.uber.cadence.workflow.Workflow;

import java.time.Duration;

public class WeatherWorkflowImpl implements WeatherWorkflow {
    private final WeatherActivity activities;

    public WeatherWorkflowImpl() {
        ActivityOptions options = new ActivityOptions.Builder()
                .setScheduleToCloseTimeout(Duration.ofSeconds(100))  // Set ScheduleToClose timeout
                .setStartToCloseTimeout(Duration.ofSeconds(60))  // Set StartToClose timeout
                .build();
        this.activities = Workflow.newActivityStub(WeatherActivity.class, options);
    }
    @Override
    public WeatherInfo getAndStoreWeatherInfo(String city) {
        WeatherInfo weatherInfo = activities.getWeatherInfo(city);
        activities.storeWeatherInfo(weatherInfo);
        return weatherInfo;
    }
}
