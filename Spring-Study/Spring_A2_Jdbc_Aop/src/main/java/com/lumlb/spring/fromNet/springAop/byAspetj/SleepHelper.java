package com.lumlb.spring.fromNet.springAop.byAspetj;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SleepHelper{
	
	//public SleepHelper(){} 
	
	@Pointcut("execution(* *.sleep())")
	//@Pointcut("execution(* *.sleep(..))")
	//@Pointcut(value="execution(* com.lml.aspectJ.fromNet.springAop.*Helper.*(..))")
	public void sleeppoint(){}
	
	@Before("SleepHelper.sleeppoint()")
	public void before(){
		System.out.println("通常情况下睡觉之前要脱衣服！");
	}
	
	@AfterReturning("SleepHelper.sleeppoint()")
	public void afterReturning(){
		 System.out.println("起床后要先穿衣服！");
	}

}
