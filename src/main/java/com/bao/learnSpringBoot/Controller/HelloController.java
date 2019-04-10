package com.bao.learnSpringBoot.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HelloController {
	@RequestMapping("/hello")
	public Object hellosay() {
		return "Hello spring boot !";
	}

	@RequestMapping("/login")
	public String login() {
		return "欢迎登陆！";
	}
}


