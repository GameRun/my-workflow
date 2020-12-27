package com.example.workflow.VO;

import org.camunda.bpm.engine.task.DelegationState;

import java.util.Date;

public class TaskInfo {

    private String assignee;
    private String caseExecutionId;
    private Date createTime;
    private String caseDefinitionId;
    private String id;
    private String processDefinitionId;
    private String processInstanceId;
    private DelegationState delegationState;


    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getCaseExecutionId() {
        return caseExecutionId;
    }

    public void setCaseExecutionId(String caseExecutionId) {
        this.caseExecutionId = caseExecutionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCaseDefinitionId() {
        return caseDefinitionId;
    }

    public void setCaseDefinitionId(String caseDefinitionId) {
        this.caseDefinitionId = caseDefinitionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public DelegationState getDelegationState() {
        return delegationState;
    }

    public void setDelegationState(DelegationState delegationState) {
        this.delegationState = delegationState;
    }
}
