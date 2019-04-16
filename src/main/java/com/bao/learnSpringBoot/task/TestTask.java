package com.bao.learnSpringBoot.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component //定义组件
public class TestTask {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	//开启任务  区间范围  毫秒  每三秒打印一次
	//@Scheduled(fixedRate=3000)
	public void sysoTimeTask() {
		System.out.println(sdf.format(new Date()));
	}
	
	//cron 表达式来  不支持年  最多 6位 4-40秒才会打印
	//@Scheduled(cron="4-40 * * * * ?")
	public void cronTimeTask() {
		System.out.println(sdf.format(new Date()));
	}
}
