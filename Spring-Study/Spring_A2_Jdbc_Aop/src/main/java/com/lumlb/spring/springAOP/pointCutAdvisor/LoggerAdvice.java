package com.lumlb.spring.springAOP.pointCutAdvisor;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * 后置通知
 * @author luml
 *
 */
public class LoggerAdvice implements AfterReturningAdvice{

	/**
	 * 在拦截到目标对象的方法执行后执行此方法
	 */
	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		System.out.println("在后置通知中记录日志。。。");
	}

}
