package com.lumlb.spring.springAOP.auto.defaultAdvisorAutoProxyCreator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自动代理
 * @author lumlb
 *
 */
public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lumlb/spring/springAOP/auto/defaultAdvisorAutoProxyCreator/beans.xml");
		
		UserService userService = (UserService) ctx.getBean("userService");
		
		userService.save();
		userService.delete();
		userService.update();
	}
}
/**
 * 目标对象中保存用户
----------在后置通知中拦截到了一个目标对象的方法:save------------
目标对象中删除用户
目标对象中修改用户
*/
