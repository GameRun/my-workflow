package com.example.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class RejectAmount implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {

    }
}
