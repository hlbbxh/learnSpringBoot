package com.bao.learnSpringBoot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bao.learnSpringBoot.Util.JsonResult;

@Controller
@RequestMapping("/expection")
public class ExceptionController {
	@RequestMapping("/zero")
	public String getExpection(){
		//在程序中出现的了异常
		int index = 0/0;
		//不能直接跳转到正常的页面
		return "freemarker/center/center";
	}
	
	@RequestMapping("/ajaxget")
	public String ajaxget() {
		//这个是直接返回请求页面的action
		return "thymeleaf/ajaxError/ajaxReq";
	}
	
	/**
	 * ajax请求的这里
	 * @return
	 */
	@RequestMapping("/getAjaxerror")
	public JsonResult getAjaxerror() {
		int ajaxerror = 0/0;
		return JsonResult.ok();
	}
}
