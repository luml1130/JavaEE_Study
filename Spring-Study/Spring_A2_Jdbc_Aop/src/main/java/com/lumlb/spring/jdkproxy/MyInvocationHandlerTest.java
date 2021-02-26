package com.lumlb.spring.jdkproxy;

public class MyInvocationHandlerTest {
	public static void main(String[] args) {
		 //实例化目标对象  
        IUserDao target=new UserDaoImpl();  
          
        //实例化Invocation  
        MyInvocationHandler invocationHandler=new MyInvocationHandler(target);  
          
        //根据目标生成代理对象  
        IUserDao proxy=(IUserDao)invocationHandler.getProxy();  
          
        //调用代理对象方法  
        proxy.save();;  
	}
}
