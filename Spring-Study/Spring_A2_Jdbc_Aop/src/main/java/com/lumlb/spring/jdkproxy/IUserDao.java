package com.lumlb.spring.jdkproxy;

/**
 * 创建业务接口，包含业务可以提供对外的接口 
 * @author Andre 2017年7月19日
 */
public interface IUserDao {
	public void save();
	public void delete();
	public void update();
}
