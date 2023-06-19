package com.crux.cadence.controller;


import com.crux.cadence.model.WeatherInfo;
import com.crux.cadence.service.WeatherService;
import com.crux.cadence.workflow.WeatherWorkflow;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.client.WorkflowOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/{city}")
    public ResponseEntity<?> getAndStoreWeatherInfo(@PathVariable String city) {
        WeatherInfo weatherInfo = weatherService.getAndStoreWeatherInfo(city);
        return ResponseEntity.ok(weatherInfo);
    }
}
