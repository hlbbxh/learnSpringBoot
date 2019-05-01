package com.bao.learnSpringBoot.TencentClass.DemoBean;

import org.springframework.stereotype.Component;

/**
 * car的实现  宝马车
 * @author Gelil
 *
 */
@Component   //让这个类让ioc容器管理  加入 @Component 注解即可
public class Baocar implements Car{

	@Override
	public void desc() {
		// TODO Auto-generated method stub
		System.out.println("我是宝马车");
	}
	
}
