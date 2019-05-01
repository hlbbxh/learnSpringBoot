package com.bao.learnSpringBoot.Aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ControllerAspect {
	private final static Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);
	
	//缺点表达式  controller下的所有类和方法
	@Pointcut("execution(public * com.bao.learnSpringBoot.Controller.*.*(..))")
	public void initC() {
		
	}
	
	@Before("initC()")
	public void before() {
		System.err.println("controller之前的方法！！！");
	}
	
	@After("initC()")
	public void after() {
		System.err.println("controller之后的方法！！！");
	}
}
