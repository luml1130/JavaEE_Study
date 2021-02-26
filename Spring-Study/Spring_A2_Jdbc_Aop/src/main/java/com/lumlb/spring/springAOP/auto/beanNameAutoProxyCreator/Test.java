package com.lumlb.spring.springAOP.auto.beanNameAutoProxyCreator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自动代理
 * @author lumlb
 *
 */
public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lumlb/spring/springAOP/auto/beanNameAutoProxyCreator/beans.xml");
		
		UserService userService = (UserService) ctx.getBean("userService");
		
		userService.save();
		userService.delete();
		userService.update();
	}
}
