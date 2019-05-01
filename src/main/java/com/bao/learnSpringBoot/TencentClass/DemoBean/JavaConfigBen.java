package com.bao.learnSpringBoot.TencentClass.DemoBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //代表配置类
public class JavaConfigBen {
	
	@Bean("ben") //代表交给ioc管理  容器可以有多个   ben 为bean的名字 不写 默认方法名
	public Car getBen() {
		return new Bencar();
	}
}
