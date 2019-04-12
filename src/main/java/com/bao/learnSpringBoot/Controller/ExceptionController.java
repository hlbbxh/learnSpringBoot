package com.bao.learnSpringBoot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
