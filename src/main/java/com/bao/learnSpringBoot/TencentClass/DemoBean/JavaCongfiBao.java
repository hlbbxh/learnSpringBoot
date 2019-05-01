package com.bao.learnSpringBoot.TencentClass.DemoBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaCongfiBao {
	
	@Bean  //获取宝马  又是一个容器  但是 ioc 就 只有一个 
	public Car getBao() {
		return new Baocar();
	}
}
