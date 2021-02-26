package com.lumlb.spring;

import javax.annotation.Resource;

import com.lumlb.spring.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)//spring整合junit进行测试
@ContextConfiguration(locations="classpath:beans.xml")//指定spring配置文件位置
public class SpringTest {

	@Resource
	private UserService userService;
	
	@Test
	public void test2(){
		userService.save();
	}
	
	
	/*@Test
	public void test1(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserService us = (UserService) ctx.getBean("userService");
		us.save();
	}*/
	
}
