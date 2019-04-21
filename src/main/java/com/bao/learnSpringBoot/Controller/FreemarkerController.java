package com.bao.learnSpringBoot.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bao.learnSpringBoot.Entity.Resource;
import com.bao.learnSpringBoot.Entity.SysUser;
import com.bao.learnSpringBoot.Entity.User;
import com.bao.learnSpringBoot.FmkFunction.ShortMethod;
import com.bao.learnSpringBoot.Util.JsonResult;

@Controller     //要返回路径的话这里是 @Controller 
@RequestMapping("/ftl")
public class FreemarkerController {
	
	@Autowired
	private Resource resource; //自动注入的资源文件对应实体
	
	@RequestMapping("/index")
	public String index(ModelMap md) { // ModelMap 相当于springmvc ModelandView
		//对应index.ftl文件    有值的
		
		List<SysUser> listuser = new ArrayList<>();
		SysUser sysUser = new SysUser();
		sysUser.setUserId(1);
		sysUser.setUserName("hyd");
		Date date = new Date();
		String dd = date.toString();
		sysUser.setUserPassworld(dd);
		sysUser.setUserEmail("1345@qq.com");
		
		SysUser sysUser2 = new SysUser();
		sysUser2.setUserId(2);
		sysUser2.setUserName("wahahah");
		Date dated = new Date();
		String dddd = dated.toString();
		sysUser2.setUserPassworld(dddd);
		sysUser2.setUserEmail("wahahah@qq.com");
		
		listuser.add(sysUser);
		listuser.add(sysUser2);
		
		md.addAttribute("resource",resource); //放入momdleandiew
		md.addAttribute("listuser",listuser);  //放入作用域  
		
		//这里直接返回  是按照  =classpath:/templates 这里来的
		return "freemarker/index";
	}
	
	@RequestMapping("/center")
	public String center() {
		return "freemarker/center/center";
	}
	/**
	 * 语法学习之基本传值
	 * @param md
	 * @return
	 */
	@RequestMapping("/yufa")
	public String ftlyufa(ModelMap md) {
		//向modelandview中存放了不同类型的三个值  其他类型 也都是一样的呦  
		md.addAttribute("StringVar","你好世界!");
		md.addAttribute("chang",1000);
		md.addAttribute("zheng",100);
		md.addAttribute("buer",true); //布尔
		md.addAttribute("nowdate",new Date());//时间
		md.addAttribute("nullzhi",null);//为空
		md.addAttribute("fuwenben","<span style='color:red'>我是红色的</span>");
		//注意  布尔类型的   要在配置文件中进行转义   改成yes  or   no   
		//直接输出true  false  会报错的呦
		return "freemarker/yufa";
	}
	/**
	 * 函数 指令
	 * @param md
	 * @return
	 */
	@RequestMapping("/func")
	public String functionandCmd(ModelMap md) {
		md.addAttribute("short_int",new ShortMethod());
		return "freemarker/functionAndCmd";
	}
	
}
