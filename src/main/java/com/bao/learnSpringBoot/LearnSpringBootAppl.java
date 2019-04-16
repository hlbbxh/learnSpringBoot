package com.bao.learnSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
//扫描 mybatis mapper 包路径 
//@MapperScan(basePackages = "com.bao.learnSpringBoot.mapper")
//自定义扫描包的路径 默认扫描此启动类下面所有的包       org.n3r.idworker   是mybatis分页插件 包含三个包
//@ComponentScan(basePackages={"com.bao.learnSpringBoot","org.n3r.idworker"})
@EnableScheduling//打开定时任务  打开即可扫描
@EnableAsync //启用异步调用
public class LearnSpringBootAppl {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootAppl.class, args);
	}

}
