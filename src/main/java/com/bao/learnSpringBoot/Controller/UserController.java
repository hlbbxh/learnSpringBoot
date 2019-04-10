package com.bao.learnSpringBoot.Controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bao.learnSpringBoot.Entity.User;
import com.bao.learnSpringBoot.Util.JsonResult;

/**
 * @author Gelil
 * user 对象的控制器
 */
//@Controller
@RestController  // @RestController = (Controller + ResponseBody)
@RequestMapping("/user")
public class UserController {
	/**
	 * @return
	 * 这是普通的方法返回json字符串
	 */
	//@ResponseBody
	@RequestMapping("/getuser")
	public User getUser() {
		User u =new User();
		u.setName("张三");
		u.setAge(18);
		u.setBirthday(new Date());
		u.setPassword("wahah");
		u.setDesc("描述啊啊");
		return u;
	}
	
	/**
	 * @return
	 * 使用封装返回json字符串
	 */
	//@ResponseBody
	@RequestMapping("/getJsonRes")
	public JsonResult getJsonUser() {
		User u =new User();
		u.setName("张三");
		u.setAge(18);
		u.setBirthday(new Date());
		u.setPassword("wahah");
		return JsonResult.ok(u);
	}
}


