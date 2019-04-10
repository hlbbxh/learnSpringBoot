package com.bao.learnSpringBoot.Controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bao.learnSpringBoot.Entity.Resource;
import com.bao.learnSpringBoot.Util.JsonResult;

@RestController
public class ResourceColtroller {
	
	@Autowired
	private Resource resource; //自动注入的资源文件对应实体
	
	@RequestMapping("/getRes")
	public JsonResult getResource() {
		Resource resource_new = new Resource();//实例化
		BeanUtils.copyProperties(resource, resource_new);//赋值资源文件到对应的实体
		return JsonResult.ok(resource_new);//返回
	}
}
