package com.lumlb.spring.proxy.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyDemo2 {
	
	public static void main(String[] args){
		// 增强女服务员 server方法.
		Waiter girlWaiter = new GirlWaiter();
		Waiter waiter = (Waiter) Proxy.newProxyInstance(
				ProxyDemo2.class.getClassLoader(),
				new Class[] { Waiter.class }, new MyInvocationHandler(girlWaiter));

//				waiter.server();
		String s = waiter.sayHello("jack");
		System.out.println(s);
	}
	
}

class MyInvocationHandler implements InvocationHandler {
	Waiter waiter = null;

	public MyInvocationHandler(Waiter waiter) {
		this.waiter = waiter;
	}

	@Override
	/**
	 * proxy:代理对象
	 * method:正在执行的那个方法.
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		/*System.out.println("微笑中...");
		waiter.server();*/
		if(method.getName().equals("server")){
			System.out.println("微笑中....");
			Object object = method.invoke(waiter, args);
			return object;
		}else{
			Object object = method.invoke(waiter, args);
			return object;
		}
		
	}
	
	// 作业:使用动态代理的方式增强request的getParameter方法.

}
