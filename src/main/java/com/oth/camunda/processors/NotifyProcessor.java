package com.oth.camunda.processors;

import com.oth.camunda.AbstractProcessor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotifyProcessor extends AbstractProcessor {

	@Override
	protected Map<String, String> processVariables(DelegateExecution execution) {
		System.out.println("send notification ..........");
		return Map.of("PROCESS_CLASS_NAME", this.getClass().getSimpleName());
	}
}
