package com.lumlb.spring.staticproxy;
/**
 * 代理主题角色（实现类）-----代理对象
 * @author luml
 */
public class ProxyUserService implements IUserService{

	private RealUserService userService;
	
	/**
	 * 覆盖默认构造器   通过一个set方法注入进来
	 * @param userService
	 */
	public void setUserService(RealUserService userService) {
		this.userService = userService;
	}
	
	//调用真实主题角色
	public void save() {
		//System.out.println("在代理主题角色中实现save()....");
		userService.save();
		//System.out.println("记录日志。。。");
	}

}
