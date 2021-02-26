package com.lumlb.spring.fromNet.springAop.byJdkProxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/lumlb/spring/fromNet/springAop/byJdkProxy/beans.xml");
        Animal dogProxy =  (Animal) context.getBean("dogProxy");  
        dogProxy.eat();  
	}
}
