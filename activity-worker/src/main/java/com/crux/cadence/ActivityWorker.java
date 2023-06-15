package com.crux.cadence;

import com.crux.cadence.implementation.WeatherActivityImpl;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import com.uber.cadence.worker.Worker;
import com.uber.cadence.worker.WorkerFactory;


public class ActivityWorker {
    public static void main(String[] args) {
        WorkflowClient workflowClient =
                WorkflowClient.newInstance(
                        new WorkflowServiceTChannel(ClientOptions.newBuilder().setHost("cadence").setPort(7933).build()),
                        WorkflowClientOptions.newBuilder().setDomain("test-domain").build());
        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
        Worker worker = factory.newWorker("weatherTaskList");
        worker.registerActivitiesImplementations(new WeatherActivityImpl());
        factory.start();
    }
}
