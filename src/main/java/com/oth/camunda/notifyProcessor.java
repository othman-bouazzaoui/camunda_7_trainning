package com.oth.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class notifyProcessor implements JavaDelegate {

	@Override
	public void execute(DelegateExecution delegateExecution) throws Exception {
		System.out.println("send notification ..........");
	}
}
