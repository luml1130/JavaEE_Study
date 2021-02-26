package com.lumlb.spring.fromNet.springAop.byAspetj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用aspectJ的自动代理
 * @author Andre 2017年7月19日
 */
public class Test {
	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("com/lumlb/spring/fromNet/springAop/byAspetj/beansAspectj.xml");
		Human human = (Human) appCtx.getBean("human");
		human.sleep();
	}
}
