package com.bao.learnSpringBoot.Entity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * @author Gelil
 * 用户类的尸实体
 */
public class User {
	
	private String name;
	
	@JsonIgnore//把不需要返回的字段忽略
	private String password;
	private Integer age;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss a",locale="zh",timezone="GMT+8")//格式化时间
	private Date birthday;
	@JsonInclude(Include.NON_NULL)//为空时不反回  只有有值的时候才返回
	private String desc;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
