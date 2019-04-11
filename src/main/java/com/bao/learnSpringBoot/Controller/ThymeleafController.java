package com.bao.learnSpringBoot.Controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bao.learnSpringBoot.Entity.Resource;
import com.bao.learnSpringBoot.Util.JsonResult;

@Controller
@RequestMapping("/th") //这是Thymeleaf的控制器
public class ThymeleafController {
	
	@RequestMapping("/index")
	public String index(ModelMap md) { 
		//对应thymelea文件   
		// 对应配置文件的  classpath:/templates/ 
		md.addAttribute("name","胡炎帝的springboot呦");
		return "thymeleaf/index";
	}
	
	@RequestMapping("/center")
	public String center() {
		return "thymeleaf/center/center";
	}
	
	
	
}
