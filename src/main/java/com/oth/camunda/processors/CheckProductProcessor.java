package com.oth.camunda.processors;

import com.oth.camunda.AbstractProcessor;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * author : Othman BOUAZZAOUI
 */

@Component
public class CheckProductProcessor extends AbstractProcessor {

	@Autowired
	private RuntimeService runtimeService;

	@Override
	protected Map<String, String> processVariables(DelegateExecution execution) {
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
		return Map.of("PROCESS_CLASS_NAME", this.getClass().getSimpleName());
	}
}
