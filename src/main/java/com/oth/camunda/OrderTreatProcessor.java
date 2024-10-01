package com.oth.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * author : Othman BOUAZZAOUI
 */
@Component
public class OrderTreatProcessor implements JavaDelegate {
	@Override
	public void execute(DelegateExecution delegateExecution) {
		System.out.println("Hello I am in " + OrderTreatProcessor.class.getSimpleName());
		delegateExecution.getVariables().forEach((s, o) -> System.out.println("key=" + s + " value=" + o));
	}
}
