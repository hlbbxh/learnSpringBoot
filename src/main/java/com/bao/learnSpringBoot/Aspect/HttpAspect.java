package com.bao.learnSpringBoot.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 这是演示aop的例子  面向切面
 * @author hlb
 * 首先是两个注解 不能少
 */
@Aspect //切面
@Component //组件注入
public class HttpAspect {
	/*
	 * //log4g 日志 private final static Logger logger =
	 * LoggerFactory.getLogger(HttpAspect.class); //记录日志 在方法进入之前
	 * 
	 * 
	 * //使用切点的方式 在方法上 定义切点 @Pointcut
	 * 
	 * @Pointcut("execution(public * com.bao.learnSpringBoot.Controller.LuckMoneyController.*(..))"
	 * ) //这是拦截 LuckMoneyController 控制器下所有的方法 所有的参数 public void log(){
	 * logger.info("这是log方法体，不会执行..."); }
	 * 
	 * 
	 * @Before("log()") public void before(JoinPoint joinpoint){ //Joinpoint获取方法和参数的
	 * 注意上lang包下的 logger.info("这是在方法之前进行拦截...."); //记录一些日志信息 // RequestContextHolder
	 * . getRequestAttributes = ServletRequestAttributes 强制转换
	 * ServletRequestAttributes attributes = (ServletRequestAttributes)
	 * RequestContextHolder.getRequestAttributes(); HttpServletRequest request =
	 * attributes.getRequest();//得到request //url 地址
	 * logger.info("url={}",request.getRequestURI()); //method 方法
	 * logger.info("method={}",request.getMethod()); //ip 地址
	 * logger.info("ip={}",request.getRemoteAddr()); //类方法
	 * joinpoint.getSignature().getDeclaringTypeName() 类名 //
	 * joinpoint.getSignature().getName() 方法名
	 * logger.info("class_method={}",joinpoint.getSignature().getDeclaringTypeName()
	 * +"."+joinpoint.getSignature().getName()); //参数
	 * logger.info("args={}",joinpoint.getArgs()); }
	 * 
	 * @After("log()") public void after(){ logger.info("在方法之后进行拦截了..."); }
	 */
    
}
