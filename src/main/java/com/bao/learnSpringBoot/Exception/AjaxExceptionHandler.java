package com.bao.learnSpringBoot.Exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bao.learnSpringBoot.Util.JsonResult;

//@RestControllerAdvice //全局异常捕获机制
public class AjaxExceptionHandler {
	/**
	 * 这是 单独测试  ajax  发射错误返回的信息
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 * 单独使用才会使用这个啦   ajax还是和web整合在一起了
	 */
	//@ExceptionHandler(value = Exception.class)//异常处理的方法体
	public JsonResult defaultErrorHandler(HttpServletRequest req,Exception e) throws Exception {
		e.printStackTrace();//打印异常的信息
		return JsonResult.errorException(e.getMessage());//放入异常信息
	}
}
