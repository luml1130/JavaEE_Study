package com.lumlb.spring.springAOP.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用spring的ＡＯＰ为指定的目标对象产生代理对象
 * @author lumlb
 *
 */
public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lumlb/spring/springAOP/advisor/beans.xml");
		
		IUserDao proxy = (IUserDao) ctx.getBean("userProxy");//获取由spring框架负责创建的代理对象
		
		proxy.save();
		proxy.delete();
		proxy.update();
	}
	/*在delete执行前记录日志
	目标对象中删除用户
	在save执行前记录日志
	目标对象中保存用户
	在update执行前记录日志
	目标对象中修改用户*/
}
