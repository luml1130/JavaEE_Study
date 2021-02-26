package com.lumlb.spring.staticproxy;
/**
 * 真实主题角色（实现类）----目标对象
 * @author luml
 */
public class RealUserService implements IUserService{
	public void save() {
		//System.out.println("记录日志。。。");
		System.out.println("在真实主题角色中保存用户。。。。");
	}

}
