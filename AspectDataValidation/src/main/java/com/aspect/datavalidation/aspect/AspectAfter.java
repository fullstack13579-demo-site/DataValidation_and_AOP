package com.aspect.datavalidation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectAfter {
	
	@After(value="execution(*  com.aspect.datavalidation.controller.PersonController.processDataFromInput(..)  )  ") 
	public void methodFromAnyClass(JoinPoint joinPoint) {
		
		System.out.println("\n triggered by "+joinPoint.getSignature().getName() + "-method from any class ");
	}
	
	
	
	@After(value="execution(*  com.aspect.datavalidation.controller.PersonController.*(..)  )  ") 
	public void  anyMethodFromPersonControllerClass(JoinPoint joinPoint) {
		
		System.out.println("\n triggered by "+joinPoint.getSignature().getName() + "-method from PersonController class ");
	}
}
