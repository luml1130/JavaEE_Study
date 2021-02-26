package com.luml.spring1;

/**
 * @author lumlb
 */
public class UserService {
	private String userName;
	
	public UserService() {
		System.out.println("UserService对象被创建了。。。");
	}
	
	public void saveUser(){
		System.out.println("保存用户" + userName);
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 初始化方法
	 */
	public void init(){
		System.out.println("UserService的初始化方法。。。");
	}
	
	/**
	 * 销毁方法
	 */
	public void destory(){
		System.out.println("UserService的销毁方法。。。");
	}
}
