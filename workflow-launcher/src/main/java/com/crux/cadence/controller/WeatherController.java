package com.crux.cadence.controller;


import com.crux.cadence.model.WeatherInfo;
import com.crux.cadence.workflow.WeatherWorkflow;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.client.WorkflowOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
public class WeatherController {
    private final WorkflowClient workflowClient;
    private final WorkflowOptions options;


    public WeatherController() {
        this.workflowClient = WorkflowClient.newInstance(
                new WorkflowServiceTChannel(ClientOptions.newBuilder().setHost("cadence").setPort(7933).build()),
                WorkflowClientOptions.newBuilder().setDomain("test-domain").build());
        this.options = new WorkflowOptions.Builder()
                .setTaskList("weatherTaskList")
                .setExecutionStartToCloseTimeout(Duration.ofSeconds(100))
                .setTaskStartToCloseTimeout(Duration.ofSeconds(60))
                .build();
    }

    @GetMapping("/weather/{city}")
    public ResponseEntity<?> getAndStoreWeatherInfo(@PathVariable String city) {
        // create a new stub with specified options
        WeatherWorkflow workflow = workflowClient.newWorkflowStub(WeatherWorkflow.class, options);
        WeatherInfo weatherInfo = workflow.getAndStoreWeatherInfo(city);
        return ResponseEntity.ok(weatherInfo);
    }
}
