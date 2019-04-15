package com.bao.learnSpringBoot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping(value = {"/","/index"})//这里是index页面同时处理两种路径
	public Object getindex(){
		//返回到主页面
		return "thymeleaf/index";
	}
}
