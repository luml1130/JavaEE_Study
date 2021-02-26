package com.lumlb.spring.fromNet.springAop.byCglibProxy;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class MethodBefore implements MethodBeforeAdvice{

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("before..."); 
	}

}
