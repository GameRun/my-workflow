package com.example.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Random;

public class AmountPreProcess implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("AmountPreProcess logg");

        Random rand = new Random();

        execution.setVariable( "amount",  Integer.parseInt(execution.getVariable("amount").toString())*rand.nextInt(10));


    }
}
