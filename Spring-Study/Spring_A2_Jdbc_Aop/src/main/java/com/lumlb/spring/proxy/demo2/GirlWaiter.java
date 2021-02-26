package com.lumlb.spring.proxy.demo2;

public class GirlWaiter implements Waiter{

	@Override
	public void server() {
		System.out.println("服务中....");
	}

	@Override
	public String sayHello(String name) {
		return "Hello "+name;
	}

}
