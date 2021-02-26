package com.luml.spring1.dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

/**
 * @author luml
 */
@Repository
public class UserDao {
	public void save(){
		System.out.println("在DAO中保存用户。。。");
	}
	
	/**
	 * 初始化方法
	 */
	@PostConstruct
	public void init(){
		System.out.println("UserDao的初始化方法。。。");
	}//<bean id="userDao" class="UserDao" init-method="init" destory-method="destory">
	
	/**
	 * 销毁方法
	 */
	@PreDestroy
	public void destory(){
		System.out.println("UserDao的销毁方法。。。");
	}
}
