package com.lumlb.spring.aspectJ.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 定义一个切面类
 * @author lumlb
 *
 */
public class MyAspect {
	
	//前置通知
	public void before1(){
		System.out.println("------前置通知-------");
	}
	
	//后置通知
	public void after1(JoinPoint jp,Object ret){
		System.out.println("=======后置通知,拦截到一个方法："+jp.getSignature().getName()+",此方法的返回值为:"+ret+"=======");
	}
	
	//环绕通知
	public Object around1(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("=======环绕通知执行（前）======");
		Object ret = pjp.proceed();
		System.out.println("=======环绕通知执行（后）======");
		return ret;
	}
	
	//异常通知
	public void afterThrowing1(Throwable ex){
		System.out.println("----------抛异常了："+ex.getMessage()+"---------");
	}
	
	//最终通知
	public void after2(){
		System.out.println("---------最终通知--------");
	}
}
