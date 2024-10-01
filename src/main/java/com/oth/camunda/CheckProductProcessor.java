package com.oth.camunda;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.test.assertions.bpmn.ProcessDefinitionAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * author : Othman BOUAZZAOUI
 */

@Component
public class CheckProductProcessor implements JavaDelegate {

	@Autowired
	private RuntimeService runtimeService;

	@Override
	public void execute(DelegateExecution execution) {
		System.out.println("Hello I am in " + CheckProductProcessor.class.getSimpleName());
		execution.getVariables().forEach((s, o) -> System.out.println("key=" + s + " value=" + o));
		execution.setVariable("errorWhenCheckProduct", "false");
		if (Integer.parseInt(String.valueOf(execution.getVariable("quantity"))) <= 0) {
			System.out.println("Error checkProductError");
			execution.setVariable("errorWhenCheckProduct", "true");
			//throw new BpmnError("checkProductError");

			//Run this process on the background
			runtimeService.startProcessInstanceByKey("PROCESS_NOTIFICATION");
		}

	}
}
