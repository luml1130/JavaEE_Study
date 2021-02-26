package com.lumlb.spring.springAOP.pointCutAdvisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用springAOP为指定的目标对象产生代理对象
 * @author luml
 *
 */
public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lumlb/spring/springAOP/pointCutAdvisor/beans.xml");
		
		UserDao proxy = (UserDao) ctx.getBean("proxyUserDao");//从spring工厂中获取一个代理对象
		
		proxy.save();
		proxy.delete();
		proxy.update();
	}
}
