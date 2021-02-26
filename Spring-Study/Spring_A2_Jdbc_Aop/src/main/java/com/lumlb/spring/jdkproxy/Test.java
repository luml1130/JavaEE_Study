package com.lumlb.spring.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用jdk的动态代理技术为指定的目标对象产生代理对象，要求目标对象必须实现一个接口
 * @author Andre 2017年7月19日
 */
public class Test {
	public static void main(String[] args) {
		final IUserDao target = new UserDaoImpl();//目标对象
		//产生的代理对象和真实的目标对象实现了同一个接口
		IUserDao proxy = (IUserDao) Proxy.newProxyInstance(target.getClass().getClassLoader(), 
								target.getClass().getInterfaces(), new InvocationHandler() {
			/**
			 * 对象目标对象进行拦截的方法(通知)
			 */
			public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
				Object o = method.invoke(target, args);//调用目标对象的方法-----放行
				//如果想要判断这个方法 那么可以这样 
				String name = method.getName();
				if(name.equals("save")){
					System.out.println("记录日志操作。。。。");
				}
				return o;
			}
		});
		proxy.save();
		proxy.delete();
		proxy.update();
	}
}
