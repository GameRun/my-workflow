package com.example.workflow;


import com.example.workflow.VO.TaskInfo;
import com.example.workflow.request.ProcessStartRequest;
import com.example.workflow.request.TaskAssignRequest;
import com.example.workflow.request.TaskComplateRequest;
import com.example.workflow.request.TaskListRequest;
import com.example.workflow.response.ProcessStartResponse;
import com.example.workflow.response.TaskAssignResponse;
import com.example.workflow.response.TaskCompleteResponse;
import com.example.workflow.response.TaskListResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.task.TaskQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("bpm")
@CrossOrigin(maxAge = 3600)
public class BpmController {

    @GetMapping("/greeting")
    @ResponseBody
    public String getRandomString(){
        return  RandomStringUtils.random(10, true, true);
    }


    @PostMapping(value = "/processStart", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ProcessStartResponse processStart(@RequestBody ProcessStartRequest request) {

        ProcessStartResponse response = new ProcessStartResponse();
        try {
            ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
            RuntimeService runtimeService = processEngine.getRuntimeService();

            Map<String, Object> variables = new HashMap<>();
            variables.put("amount", request.getAmount());
            variables.put("assign", request.getAssignUser());

            ProcessInstanceWithVariables createResponse = runtimeService.createProcessInstanceByKey(request.getProcessDefinitionKey())
                    .setVariables(variables).executeWithVariablesInReturn();

            response.setProcessInstanceId(createResponse.getProcessInstanceId());
            response.setId(createResponse.getId());
            response.setIslemSonuc("Basarili");
        } catch (Exception e) {
            response.setIslemSonuc("Basarisiz");
            response.setHataAciklama(e.toString());
        }

        return response;
    }

    @PostMapping(value = "/taskList", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public TaskListResponse listTask(@RequestBody TaskListRequest request) {
        TaskListResponse response = new TaskListResponse();

        try {
            response.setIslemSonuc("Basarılı");
            List<Task> taskList = createQueryCriteria(request).list();
            for (Task task : taskList) {
                TaskInfo taskInfo = new TaskInfo();
                taskInfo.setAssignee(task.getAssignee());
                taskInfo.setCaseExecutionId(task.getCaseExecutionId());
                taskInfo.setCreateTime(task.getCreateTime());
                taskInfo.setCaseDefinitionId(task.getCaseDefinitionId());
                taskInfo.setId(task.getId());
                taskInfo.setProcessDefinitionId(task.getProcessDefinitionId());
                taskInfo.setProcessInstanceId(task.getProcessInstanceId());
                taskInfo.setDelegationState(task.getDelegationState());

                response.getTaskInfoList().add(taskInfo);
            }
        } catch (Exception e) {
            response.setIslemSonuc("Basarisiz");
            response.setHataAciklama(e.toString());
        }

        return response;
    }


    @PostMapping(value = "/taskComplate", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public TaskCompleteResponse taskComplate(@RequestBody TaskComplateRequest request) {
        TaskCompleteResponse response = new TaskCompleteResponse();

        try {
            response.setIslemSonuc("Başarılı");
            ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
            TaskService taskService = processEngine.getTaskService();

            Map<String, Object> variables = new HashMap<>();
            variables.put("approve", request.getApprove());

            taskService.complete(request.getTaskId(), variables);

        } catch (Exception e) {
            response.setIslemSonuc("Başarısız");
            response.setHataAciklama(e.toString());
        }
        return response;
    }

    @PostMapping(value = "/taskAssign", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public TaskAssignResponse taskAssign(@RequestBody TaskAssignRequest request) {
        TaskAssignResponse response = new TaskAssignResponse();

        try {
            response.setIslemSonuc("Basarili");

            ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
            TaskService taskService = processEngine.getTaskService();
            taskService.setAssignee(request.getTaskId(), request.getUserId());


        } catch (Exception e) {
            response.setIslemSonuc("Başarısız");
            response.setHataAciklama(e.toString());
        }
        return response;
    }

    private TaskQuery createQueryCriteria(TaskListRequest request) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        TaskQuery query = taskService.createTaskQuery();

        if (request.getProcessInstanceId() != null && request.getProcessInstanceId() != "") {
            query.processInstanceId(request.getProcessInstanceId());
        }

        if (request.getAssign() != null && request.getAssign() != "") {
            query.taskAssigneeIn(request.getAssign());
        }

        if (request.getCandidate() != null && request.getCandidate() != "") {
            query.taskCandidateUser(request.getCandidate());
        }

        if (request.getCandidateGroup() != null && request.getCandidateGroup() != "") {
            query.taskCandidateGroupIn(Arrays.asList(request.getCandidateGroup()));
        }

        return query;
    }

    public void test(){
        System.out.println("111");
    }


}
