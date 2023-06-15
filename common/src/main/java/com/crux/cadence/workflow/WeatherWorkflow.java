package com.crux.cadence.workflow;

import com.crux.cadence.model.WeatherInfo;
import com.uber.cadence.workflow.WorkflowMethod;

public interface WeatherWorkflow {
    @WorkflowMethod(executionStartToCloseTimeoutSeconds = 300)
    WeatherInfo getAndStoreWeatherInfo(String city);
}
