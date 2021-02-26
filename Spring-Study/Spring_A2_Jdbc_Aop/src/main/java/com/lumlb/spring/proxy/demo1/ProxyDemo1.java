package com.lumlb.spring.proxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyDemo1 {
	@Test
	public void demo1(){
		// 第一个参数：是类的加载器
		ClassLoader loader = ProxyDemo1.class.getClassLoader();
		// 第二个参数:这要对哪个类生成代理.
					//但是在spring中动态代理是说 第二个参数第目标对象所有已经实现了的数组
					// target.getClass().getInterfaces()
		Class[] interfaces = {IPerson.class};
		// 第三个参数:就是InvocationHandler接口实现
		IPerson person = (IPerson) Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {

				return null;
			}
		});
		// 说明我们调用代理类任何一个方法  invoke方法都会执行.
		person.run();
	}
}
