package com.luml.mb.test;

import com.luml.mb.domain.User;
import com.luml.mb.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringMybatisTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IUserService us = (IUserService) ctx.getBean("userService");

		User user = new User("a", "b", "c");
		us.saveUser(user );
		
		System.out.println(us.getClass().getSimpleName());
	}
}
