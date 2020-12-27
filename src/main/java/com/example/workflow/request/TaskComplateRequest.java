package com.example.workflow.request;

public class TaskComplateRequest {

    private String taskId;

    private boolean approve;

    public boolean getApprove() {
        return approve;
    }

    public void setApprove(boolean approve) {
        this.approve = approve;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
