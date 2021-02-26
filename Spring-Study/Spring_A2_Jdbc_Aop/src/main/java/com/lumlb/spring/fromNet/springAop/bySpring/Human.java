package com.lumlb.spring.fromNet.springAop.bySpring;

public class Human implements Sleepable{

	@Override
	public void sleep() {
		System.out.println("睡觉了！梦中自有王昭君！");
	}

}
