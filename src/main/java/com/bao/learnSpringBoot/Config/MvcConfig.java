package com.bao.learnSpringBoot.Config;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.bao.learnSpringBoot.Controller.interceptor.OneInterceptor;

/**
 * 当我们的thymelaf中的模板是一个静态的页面的时候，
 * 要想访问的话需要添加一个空的控制器来进行跳转，
 * 这样就很麻烦，所以我们要加入自己的解析配置了类
 * @author Gelil
 *
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer{
	
	/**
	 * 重写这个方法  加入空的  thymeleaf 的空的  模板
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addViewController("/kong").setViewName("thymeleaf/kong");
		//                          url                  资源地址 
	}
	
	/**
	 * 添加时间格式化器  不如直接使用
	 * spring.mvc.date-format=yyyy-MM-dd 也是可以在配置文件中指定时间格式
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
	}
	
	/**
	 * 消息转发器  就是格式化了一下时间日期  使用的阿里的 fastjson 
	 * 感觉并没有什么用  springboot 不知自带
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter fc = new FastJsonHttpMessageConverter();
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fc.setFastJsonConfig(config);
		converters.add(fc);
		/*	使用  在实体类上  
		 * 	@JSONField(format="yyyy-MM-dd")
			private Date birthday;
		 * */
	}
	
	/**
	 * 这是拦截器的配置  
	 * 同样都是这个方法 addInterceptors
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new OneInterceptor()).
								addPathPatterns("/one/**").
								excludePathPatterns("/one/index");
	}
}
