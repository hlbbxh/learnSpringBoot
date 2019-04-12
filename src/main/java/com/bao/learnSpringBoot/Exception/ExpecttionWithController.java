package com.bao.learnSpringBoot.Exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice //首先是这个注解
public class ExpecttionWithController {
	public static final String ERROR_VIEW_INDEX = "error";
	public static final String ERROR_VIEW_CONTENT = "thymeleaf/errer/error";
	//出现异常应该会被他捕获
	@ExceptionHandler(value = Exception.class)//异常
	public Object defaultErrorHandler(HttpServletRequest request,Exception e)throws Exception{
	  //e.printStackTrace();  这串代码打印的是长长的公色错误信息  传统的错误信息
      ModelAndView mav = new ModelAndView();
      mav.addObject("exception", e);
      mav.addObject("url",request.getRequestURI());
      mav.setViewName(ERROR_VIEW_CONTENT);
      return mav;
	}
}
