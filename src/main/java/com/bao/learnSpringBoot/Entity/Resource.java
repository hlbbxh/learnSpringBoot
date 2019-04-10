package com.bao.learnSpringBoot.Entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration //代表引用资源文件的代表是配置
@ConfigurationProperties(prefix="com.learn") //资源文件的前缀
@PropertySource(value="classpath:resource.properties")//资源文件地址
public class Resource {
	private String name;
	private String web;
	private String language;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
