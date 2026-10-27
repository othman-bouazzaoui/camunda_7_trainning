package com.oth.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Map;

public abstract class AbstractProcessor implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Map<String, String> evaluatedVariables = processVariables(execution);
        System.out.println(evaluatedVariables);
    }

     protected abstract Map<String, String> processVariables(DelegateExecution execution);
}
