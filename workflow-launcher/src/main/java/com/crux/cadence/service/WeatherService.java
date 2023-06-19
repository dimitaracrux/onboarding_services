package com.crux.cadence.service;

import com.crux.cadence.model.WeatherInfo;
import com.crux.cadence.workflow.WeatherWorkflow;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class WeatherService {

    private final WorkflowClient workflowClient;

    @Autowired
    public WeatherService(WorkflowClient workflowClient) {
        this.workflowClient = workflowClient;
    }

    public WeatherInfo getAndStoreWeatherInfo(String city) {
        WorkflowOptions options = new WorkflowOptions.Builder()
                .setTaskList("weatherTaskList")
                .setExecutionStartToCloseTimeout(Duration.ofSeconds(100))
                .setTaskStartToCloseTimeout(Duration.ofSeconds(60))
                .build();
        WeatherWorkflow workflow = workflowClient.newWorkflowStub(WeatherWorkflow.class, options);
        return workflow.getAndStoreWeatherInfo(city);
    }
}
