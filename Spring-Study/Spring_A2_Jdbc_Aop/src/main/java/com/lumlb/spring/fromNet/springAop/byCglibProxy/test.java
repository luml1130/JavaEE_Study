package com.lumlb.spring.fromNet.springAop.byCglibProxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/lumlb/spring/fromNet/springAop/byCglibProxy/beans.xml");
        Dog Dog =  (Dog) context.getBean("dogProxy");  
        Dog.eat();  
	}
}
