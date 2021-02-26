package com.lumlb.spring.aspectJ.xml;
/**
 * 目标对象
 * @author lumlb
 *
 */
public class UserDao{

	public void delete() {
		System.out.println("目标对象中删除用户");
	}

	public Integer save() {
		System.out.println("目标对象中保存用户");
		//int i = 1/0;
		return 10;
	}

	public void update() {
		System.out.println("目标对象中修改用户");
	}

}
