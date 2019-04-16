package com.bao.learnSpringBoot.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bao.learnSpringBoot.Entity.SysUser;
import com.bao.learnSpringBoot.Entity.User;
import com.bao.learnSpringBoot.Util.JsonResult;
import com.bao.learnSpringBoot.Util.JsonUtils;
import com.bao.learnSpringBoot.Util.RedisOperator;

@RestController
@RequestMapping("/redis")
public class RedisController {
	
	//自动装载 和 StringRedisTemplate 这个家伙
	@Autowired 
	private StringRedisTemplate redisTemplate;
	
	//注入redis对象操作类
	@Autowired
	private RedisOperator redis;
	
	/**
	 * 向redis存入数据
	 * 在取出数据   简单的的方式
	 * @return
	 */
	@RequestMapping("/getname")
	public JsonResult testRedis() {
		//存入数据
		redisTemplate.opsForValue().set("age","21");
		//取数据
		return JsonResult.ok(redisTemplate.opsForValue().get("name"));
	}
	
	/**
	 * 这是对象转换json的操作
	 * 
	 * @return
	 */
	@RequestMapping("/getjsonRedisUser")
	private JsonResult testJsonRedis() {
		
		SysUser sysUser = new SysUser();
		sysUser.setUserId(2);
		sysUser.setUserName("huayndi");
		sysUser.setUserPassworld("passwor");
		sysUser.setUserEmail("13554@qq.com");
		//放入   以json字符的方式放入
		redisTemplate.opsForValue().set("json:user", JsonUtils.objectToJson(sysUser));
		//取出 转换为usuer对象
		SysUser jsonToPojoSysuer = JsonUtils.jsonToPojo(redisTemplate.opsForValue().get("json:user"), SysUser.class);
		
		return JsonResult.ok(jsonToPojoSysuer);
	}
	
	/**
	 * 使用分装的操作类  来存入对象的集合
	 * @return
	 */
	@RequestMapping("/getJsonRedisList")
	public JsonResult getJsonList() {
	
		//对象1
		User u1 = new User();
		u1.setAge(19);
		u1.setName("imooc");
		u1.setPassword("123456");
		u1.setBirthday(new Date());
		
		//对象2
		User u2 = new User();
		u2.setAge(17);
		u2.setName("hello imooc");
		u2.setPassword("123456");
		u2.setBirthday(new Date());
		
		//放入集合
		List<User> userList = new ArrayList<>();
		userList.add(u1);
		userList.add(u2);
		
		//放入redis
		redis.set("json:info:userlist", JsonUtils.objectToJson(userList), 2000);
		
		//获得key的value
		String userListJson = redis.get("json:info:userlist");
		//转换对象
		List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);
		
		//输出对象
		return JsonResult.ok(userListBorn);
	}
}
