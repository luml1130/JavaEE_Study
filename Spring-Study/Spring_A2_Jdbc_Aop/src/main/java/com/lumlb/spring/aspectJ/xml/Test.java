package com.lumlb.spring.aspectJ.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用aspectJ的自动代理
 * @author zhaoqx
 *
 */
public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lumlb/spring/aspectJ/xml/beans.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		userDao.save();
		userDao.delete();
		userDao.update();
		
		System.out.println(userDao.getClass().getName());
	}
}
