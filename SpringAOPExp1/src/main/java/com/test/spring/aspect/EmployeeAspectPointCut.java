package com.test.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EmployeeAspectPointCut {

	@Before("getNamePointCut()")
	public void loggingAdvice() {
		System.out.println("execution logging advice on getName()");
	}
	
	@Before("getNamePointCut()")
	public void secondAdvice() {
		System.out.println("executing second advice on getName()");
	}
	
	@Pointcut("execution(public String getName())")
	public void getNamePointcut() {
		
	}
	
	@Before("allMethodsPointcut()")
	public void allServiceMethodsAdvice() {
		System.out.println("Before executing service method");
	}
	
	@Pointcut("within(com.test.service.*)")
	public void allMethodsPointcut(){
		
	}
}
