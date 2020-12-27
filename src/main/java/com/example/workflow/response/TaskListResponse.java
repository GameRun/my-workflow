package com.example.workflow.response;

import com.example.workflow.VO.TaskInfo;

import java.util.ArrayList;
import java.util.List;

public class TaskListResponse extends IslemSonuc {

    private List<TaskInfo> taskInfoList = new ArrayList<>();

    public List<TaskInfo> getTaskInfoList() {
        return taskInfoList;
    }

    public void setTaskInfoList(List<TaskInfo> taskInfoList) {
        this.taskInfoList = taskInfoList;
    }
}
