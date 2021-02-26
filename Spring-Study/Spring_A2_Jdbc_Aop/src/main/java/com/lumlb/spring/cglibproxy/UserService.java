package com.lumlb.spring.cglibproxy;

/**
 * 目标对象
 * @author Andre 2017年7月19日
 */
public class UserService {
	public void save(){
		System.out.println("目标对象中的保存方法。。。。");
	}
	public void delete(){
		System.out.println("目标对象中的删除方法。。。。");
	}
	public void update(){
		System.out.println("目标对象中的修改方法。。。。");
	}
}
