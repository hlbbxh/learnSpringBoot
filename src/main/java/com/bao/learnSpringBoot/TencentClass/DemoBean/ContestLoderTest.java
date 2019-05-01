package com.bao.learnSpringBoot.TencentClass.DemoBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContestLoderTest {
	public static void main(String[] args) {
		//创建  AnnotationConfigApplicationContext 对象   并且指定 父对象 
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(ParentConfig.class);
		Car bencar = (Car) context.getBean("ben"); //使用bean 注解  的value 获取
		bencar.desc();
		Car baocar = (Car) context.getBean("getBao"); //默认使用方法名小写 即可 也是可以获取
		baocar.desc();
	}
}
