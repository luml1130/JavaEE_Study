package com.lumlb.spring.springAOP.auto.defaultAdvisorAutoProxyCreator;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * 后置通知
 * @author lumlb
 *
 */
public class MyAdvice implements AfterReturningAdvice{

	/**
	 * 当被拦截到的目标方法执行后，执行此方法
	 */
	public void afterReturning(Object arg0, Method method, Object[] arg2,
			Object arg3) throws Throwable {
		System.out.println("----------在后置通知中拦截到了一个目标对象的方法:"+method.getName()+"------------");
	}

}
