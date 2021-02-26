package com.lumlb.spring.jdkproxy;
/**
 * 创建业务接口实现类  目标对象
 * @author Andre 2017年7月19日
 */
public class UserDaoImpl implements IUserDao{

	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("目标对象中删除用户");
	}

	public void save() {
		// TODO Auto-generated method stub
		System.out.println("目标对象中保存用户");
	}

	public void update() {
		// TODO Auto-generated method stub
		System.out.println("目标对象中修改用户");
	}

}
