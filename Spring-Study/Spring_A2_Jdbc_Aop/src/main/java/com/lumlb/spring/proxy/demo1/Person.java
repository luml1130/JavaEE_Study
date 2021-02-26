package com.lumlb.spring.proxy.demo1;

public class Person implements IPerson{
	public void eat() {
		System.out.println("eat");
	}

	public String sayHello(String name) {
		return "Hello " + name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
