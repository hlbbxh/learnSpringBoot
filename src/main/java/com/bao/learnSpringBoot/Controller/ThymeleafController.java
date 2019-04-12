package com.bao.learnSpringBoot.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bao.learnSpringBoot.Entity.User;

@Controller
@RequestMapping("/th") //这是Thymeleaf的控制器
public class ThymeleafController {
	
	@RequestMapping("/index")
	public String index(ModelMap md) { 
		//对应thymeleaf文件   
		// 对应配置文件的  classpath:/templates/ 
		md.addAttribute("name","胡炎帝的springboot呦");
		return "thymeleaf/index";
	}
	
	@RequestMapping("/center")
	public String center() {
		return "thymeleaf/center/center";
	}
	
	//这是学习thymeleaf语法的控制器
	@RequestMapping("/test")
    public String test(ModelMap map) {
		
		User u = new User();
		u.setName("superadmin");
		u.setAge(10);
		u.setPassword("123465");
		u.setBirthday(new Date());
		u.setDesc("<font color='green'><b>hello imooc</b></font>");
		
		map.addAttribute("user", u);
		
		//放入js代码 不会被utext将解析
		map.addAttribute("alert","alert('hello world')");
		
		User u1 = new User();
		u1.setAge(19);
		u1.setName("superadmin");
		u1.setPassword("123456");
		u1.setBirthday(new Date());
		
		User u2 = new User();
		u2.setAge(17);
		u2.setName("superadmin");
		u2.setPassword("123456");
		u2.setBirthday(new Date());
		
		List<User> userList = new ArrayList<>();
		userList.add(u);
		userList.add(u1);
		userList.add(u2);
		
		map.addAttribute("userList", userList);
		
        return "thymeleaf/test";
    }
	
	//提交过来的表达表单在这个方法
	@PostMapping("postform")
    public String postform(User u) {
		
		System.out.println("姓名：" + u.getName());
		System.out.println("年龄：" + u.getAge());
		
		//请求转发到下面的方法  并且在下一个页面获取相对于的数据信息
        return "forward:/th/submitScuess";
    }
	
	@RequestMapping("/submitScuess")
	public String submitScuess(){
		//转发过来的会自动封装属性到作用域中
		return "thymeleaf/submitScuess";
	}
}
