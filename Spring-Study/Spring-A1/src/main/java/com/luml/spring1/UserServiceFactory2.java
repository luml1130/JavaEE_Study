package com.luml.spring1;
/**
 * 使用实例工厂方法创建对象
 * @author lmlb
 *
 */
public class UserServiceFactory2 {
	public UserService createUserService(){
		return new UserService();
	}
}
