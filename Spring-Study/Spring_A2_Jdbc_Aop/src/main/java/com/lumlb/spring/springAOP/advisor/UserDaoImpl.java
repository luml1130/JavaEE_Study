package com.lumlb.spring.springAOP.advisor;
/**
 * 目标对象
 * @author lumlb
 *
 */
public class UserDaoImpl implements IUserDao{

	public void delete() {
		System.out.println("目标对象中删除用户");
	}

	public void save() {
		System.out.println("目标对象中保存用户");
	}

	public void update() {
		System.out.println("目标对象中修改用户");
	}

}
