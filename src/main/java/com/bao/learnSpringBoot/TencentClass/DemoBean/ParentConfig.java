package com.bao.learnSpringBoot.TencentClass.DemoBean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Gelil
 * 代表上层容器
 */
@Configuration  //也需要  @Configuration 
@Import({JavaCongfiBao.class,JavaConfigBen.class}) //导入两个自子容器  
public class ParentConfig {
	
}
