package com.bao.learnSpringBoot.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bao.learnSpringBoot.Controller.interceptor.OneInterceptor;
import com.bao.learnSpringBoot.Controller.interceptor.TwoInterceptor;

//表明当前是一个适配器 
/**
 * 现在 可以参考 WebMvcConfigurer 的配置  
 * WebMvcConfigurerAdapter 这个好像已经过时了  
 * 重新的方法是一样的 addInterceptors 都是这个
 * @author Gelil
 *
 */
@Configuration 
public class FilterConfig extends WebMvcConfigurerAdapter{ //继承WebMvcConfigurerAdapter
	
	//重新写这个方法  可以点 上面 source override 可以重写的方法
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		//直接用registry.addaddInterceptor 方法  参数为自己定义的拦截器 
		//registry.addInterceptor(new OneInterceptor()).addPathPatterns("/tow/**"); //这里的one 是在 OneController 中的requestmapper中 
								//直接 new 自己拦截器                .添加到 路劲中                     拦截所有的one后面的 url  写 * 拦截所有的url
		
		//registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/one/**").addPathPatterns("/tow/**"); //拦截
		
		//需要注册多个拦截器的时候 直接在后面继续add 链式书写  拦截按注册顺序
/*		registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/tow/**")
		                                             .addPathPatterns("/one/**");*/
		//不需要拦截的 .excludePathPatterns(patterns); 这个方法  也可以是多个
		super.addInterceptors(registry);
	}
}
