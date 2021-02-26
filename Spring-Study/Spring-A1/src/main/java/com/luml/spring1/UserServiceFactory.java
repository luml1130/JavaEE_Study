package com.luml.spring1;
/**
 * 创建UserService对象的工厂
 * @author lumlb
 *
 */
public class UserServiceFactory {
	
	public static UserService createUserService(){
		return new UserService();
	}
}
