package com.oth.camunda.processors;

import com.oth.camunda.AbstractProcessor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * author : Othman BOUAZZAOUI
 */
@Component
public class OrderTreatProcessor extends AbstractProcessor {

	@Override
	protected Map<String, String> processVariables(DelegateExecution execution) {
		System.out.println("Hello I am in " + OrderTreatProcessor.class.getSimpleName());
		execution.getVariables().forEach((s, o) -> System.out.println("key=" + s + " value=" + o));
		return Map.of("PROCESS_CLASS_NAME", this.getClass().getSimpleName());
	}
}
