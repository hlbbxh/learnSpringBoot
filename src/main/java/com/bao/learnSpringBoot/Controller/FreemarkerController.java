package com.bao.learnSpringBoot.Controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bao.learnSpringBoot.Entity.Resource;
import com.bao.learnSpringBoot.Util.JsonResult;

@Controller     //要返回路径的话这里是 @Controller 
@RequestMapping("/ftl")
public class FreemarkerController {
	
	@Autowired
	private Resource resource; //自动注入的资源文件对应实体
	
	@RequestMapping("/index")
	public String index(ModelMap md) { // ModelMap 相当于springmvc ModelandView
		//对应index.ftl文件    有值的
		md.addAttribute("resource",resource);
		//这里直接返回  是按照  =classpath:/templates 这里来的
		return "freemarker/index";
	}
	
	@RequestMapping("/center")
	public String center() {
		return "freemarker/center/center";
	}
	
	
}
