package com.lumlb.spring.aspectJ.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  使用aspectJ的自动代理
 * @author Andre 2017年7月19日
 */
public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lumlb/spring/aspectJ/annotation/beans.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		userDao.save();
		//userDao.delete();
		//userDao.update();
		
		//System.out.println(userDao.getClass().getName());
	}
}
