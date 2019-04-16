package com.bao.learnSpringBoot.Async;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//直接返回json字符
@RequestMapping("async")
public class DoTask {
	
	@Autowired
    private AsyncTask asyncTask;//注入
	
    @RequestMapping("openasync")
    public String test1() throws Exception {
    	
    	long start = System.currentTimeMillis();//开始时间
    	
    	Future<Boolean> a = asyncTask.doTask11();
    	Future<Boolean> b = asyncTask.doTask22();
    	Future<Boolean> c = asyncTask.doTask33();
    	
    	//循环 只要有任务没完成 就不可以出来呦
    	while (!a.isDone() || !b.isDone() || !c.isDone()) {
    		if (a.isDone() && b.isDone() && c.isDone()) {
    			break;
    		}
    	}
    	
    	long end = System.currentTimeMillis();//结束时间
    	
    	String times = "任务全部完成，总耗时：" + (end - start) + "毫秒";
    	System.out.println(times);
    	
    	return times;
    }
}
