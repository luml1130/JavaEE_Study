package com.lumlb.spring.fromNet.springAop.bySpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAuto {
	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("com/lumlb/spring/fromNet/springAop/bySpring/beansAuto.xml");
        Sleepable sleeper = (Sleepable)appCtx.getBean("human");
        sleeper.sleep();
	}
}
