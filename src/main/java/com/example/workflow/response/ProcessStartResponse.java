package com.example.workflow.response;

import org.camunda.bpm.engine.task.Task;

public class ProcessStartResponse extends IslemSonuc {

    private String processInstanceId;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }
}
