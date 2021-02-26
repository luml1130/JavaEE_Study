package com.lumlb.spring.springAOP.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;


/**
 *  定义一个记录日志的通知
 * @author Andre 2017年7月19日
 */
public class LoggerAdvice implements MethodBeforeAdvice{

	/**
	 * 拦截到目标对象方法之前执行此方法
	 */
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("在" + method.getName() + "执行前记录日志");
	}

}
