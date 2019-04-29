package com.bao.learnSpringBoot.Aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect //切面
@Component //组件注入
public class HttpAspect {

    //log4g 日志
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 在切入的方法体之前进行拦截
     * LuckMoneyController . * 代表改该方法的所有方法
     * (..)代表所有参数都拦截
     *
     */
/*    @Before("execution(public * com.hlbbxh.luckmoney.controller.LuckMoneyController.*(..))")
    public void log(){
        System.out.printf("在方法进入之前拦截了...");
    }

    @After("execution(public * com.hlbbxh.luckmoney.controller.LuckMoneyController.*(..))")
    public void after(){
        System.out.printf("在方法之后进行拦截了...");
    }
*/
    /**
     * @Before("execution(public * com.bao.learnSpringBoot.Controller.LuckmoneyController.*(..))")
     * @After("execution(public * com.bao.learnSpringBoot.Controller.LuckmoneyController.*(..))")
     * 但是这样写 又麻烦了  上面的切点表达式写了两次
     *
     */
    @Pointcut("execution(public * com.bao.learnSpringBoot.Controller.LuckmoneyController.*(..))")
    public void log(){
        logger.info("这是log方法体，不会执行...");
    }

    @Before("log()")
    public void before(JoinPoint joinpoint){ //Joinpoint获取方法和参数的  注意上lang包下的
        logger.info("这是在方法之前进行拦截....");
        //记录一些日志信息
        // RequestContextHolder . getRequestAttributes = ServletRequestAttributes 强制转换
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();//得到request
        //url 地址
        logger.info("url={}",request.getRequestURI());
        //method 方法
        logger.info("method={}",request.getMethod());
        //ip 地址
        logger.info("ip={}",request.getRemoteAddr());
        //类方法   joinpoint.getSignature().getDeclaringTypeName() 类名
        //  joinpoint.getSignature().getName()  方法名
        logger.info("class_method={}",joinpoint.getSignature().getDeclaringTypeName()+"."+joinpoint.getSignature().getName());
        //参数
        logger.info("args={}",joinpoint.getArgs());
    }

    @After("log()")
    public void after(){
        logger.info("在方法之后进行拦截了...");
    }

    /**
     * 在方法之后 获取返回的对象
     * 使用  @AfterReturning 注解
     * 重写tosring 方法  打印
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void afterres(Object object){
        //logger.info("resullt={}",object.toString());
    }

}
