package com.bao.learnSpringBoot.TencentClass.DemoBean;

import org.springframework.stereotype.Component;

/**
 * car的具体实现之本田车
 * @author Gelil
 *
 */
@Component   //让这个类让ioc容器管理  加入 @Component 注解即可
public class Bencar implements Car{

	@Override
	public void desc() {
		// TODO Auto-generated method stub
		System.out.println("我是一个本田车");
	}
	
}
