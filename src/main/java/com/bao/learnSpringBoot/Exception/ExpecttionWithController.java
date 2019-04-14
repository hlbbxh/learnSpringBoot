package com.bao.learnSpringBoot.Exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.bao.learnSpringBoot.Util.JsonResult;

@ControllerAdvice //首先是这个注解
public class ExpecttionWithController {
	public static final String ERROR_VIEW_INDEX = "error";
	public static final String ERROR_VIEW_CONTENT = "thymeleaf/errer/error";
	//出现异常应该会被他捕获
	
	//这是404的拦截页面
	@ExceptionHandler(value = NoHandlerFoundException.class)//404页面
	public Object NoFoudExceptionHandler(HttpServletRequest request,Exception e)throws Exception{
      ModelAndView mav = new ModelAndView();
      mav.setViewName(ERROR_VIEW_INDEX);
      return mav;
	}
	
	/**
	 * 这个方法进行ajax异常的增强  兼容ajax请求异常捕获
	 * @param request
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)//异常
	public Object defaultErrorHandler(HttpServletRequest request,Exception e)throws Exception{
	  //e.printStackTrace();  这串代码打印的是长长的公色错误信息  传统的错误信息
	  if (isAjax(request)) {
		  return JsonResult.errorException(e.getMessage()); //ajax 异常返回
	  }else {
		  ModelAndView mav = new ModelAndView();
	      mav.addObject("exception", e);
	      mav.addObject("url",request.getRequestURI());
	      mav.setViewName(ERROR_VIEW_CONTENT);
	      return mav; //页面跳转返回
      }
	}
	
	/**
	 * 
	 * @Description: 判断是否是ajax请求
	 * @author 
	 * @version V1.0
	 */
	public static boolean isAjax(HttpServletRequest httpRequest){
		//通过请求头信息判断是不是ajax请求
		return  (httpRequest.getHeader("X-Requested-With") != null  
					&& "XMLHttpRequest"
						.equals( httpRequest.getHeader("X-Requested-With").toString()) );
	}

}
