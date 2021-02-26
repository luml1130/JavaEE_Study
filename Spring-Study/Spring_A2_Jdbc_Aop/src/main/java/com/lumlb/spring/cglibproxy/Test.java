package com.lumlb.spring.cglibproxy;

import java.lang.reflect.Method;

/*import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;*/
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;



/**
 * 使用cglib为指定的目标对象产生代理对象
 * @author Andre 2017年7月19日
 */
public class Test {
	public static void main(String[] args) {
		final UserService target = new UserService();//目标对象
		
		Enhancer en = new Enhancer();
		en.setSuperclass(target.getClass());//指定产生的代理对象的父类
		//设置回调   里面是一个拦截器对象
		en.setCallback(new MethodInterceptor() {
			/**
			 * 对象目标对象进行拦截的方法
			 * @param obj CGlib根据指定父类生成的代理对象
			 * @param method 拦截的方法
			 * @param args 拦截方法的参数数组
			 * @param proxy 方法的代理对象，用于执行父类的方法 
			 */
			public Object intercept(Object arg0, Method arg1, Object[] arg2,
					MethodProxy arg3) throws Throwable {
				System.out.println("拦截到了一个目标对象的方法：" + arg1.getName());
				if(arg1.getName().equals("save")){
					System.out.println("在代理对象中开启事务。。。。");
				}
				Object o = arg1.invoke(target, arg2);//调用目标对象的方法
				if(arg1.getName().equals("save")){
					System.out.println("在代理对象中提交事务。。。。");
				}
				return o;
			}
		});
		
		UserService proxy = (UserService) en.create();//产生代理对象
		
		proxy.save();
		proxy.delete();
		proxy.update();
	}
}
