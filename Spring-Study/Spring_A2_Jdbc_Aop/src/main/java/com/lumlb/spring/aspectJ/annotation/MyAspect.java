package com.lumlb.spring.aspectJ.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 定义一个切面类(切面 = 切点 + 通知)
 * @author Andre 2017年7月19日
 */
@Aspect
public class MyAspect {
	
	//抽取一个切点表达式
	@Pointcut(value="execution(* com.lml.aspectJ.annotation.*Dao.*(..))")
	public void pointCut1(){}

	//定义一个前置通知
	//@Before(value="execution(* com.lml.aspectJ.annotation.*Dao.*(..))")
	//引用上面定义的切点表达式
	@Before("MyAspect.pointCut1()")
	public void before1(){
		System.out.println("-------前置通知1------");
	}
	
	//定义一个前置通知
	@Before(value="execution(* com.lml.aspectJ.annotation.*Dao.*(..))")
	public void before2(JoinPoint jp){
		//System.out.println("-------前置通知2中拦截到一个方法："+jp.getSignature().getName()+"------");
	}
	
	//定义一个后置通知
	@AfterReturning(value="execution(* com.lml.aspectJ.annotation.*Dao.*(..))",returning="retVal")
	public void after1(JoinPoint jp,Object retVal){
		//System.out.println("----------后置通知,拦截到一个方法"+jp.getSignature().getName()+"此方法的返回值为:"+retVal+"----------");
	}
	
	//定义一个环绕通知
	@Around(value="execution(* com.lml.aspectJ.annotation.*Dao.*(..))")
	public Object around1(ProceedingJoinPoint pjp) throws Throwable{
		//这个参数是可执行的拦截点
		//System.out.println("--------环绕通知执行（前）-------");
		//调用目标方法
		Object ret = pjp.proceed();
		//System.out.println("--------------环绕通知执行（后）-----------------");
		return ret;
	}
	
	//定义一个异常通知
	@AfterThrowing(value="execution(* com.lml.aspectJ.annotation.*Dao.*(..))",throwing="ex")
	public void afterThrowing1(JoinPoint jp,Throwable ex){
		//System.out.println("------------"+jp.getSignature().getName()+"抛异常了----------" + ex.getMessage());
	}
	
	//定义一个最终通知
	@After(value="execution(* com.lml.aspectJ.annotation.*Dao.*(..))")
	public void after1(){
		System.out.println("---------最终通知执行了-----------");
	}
}
