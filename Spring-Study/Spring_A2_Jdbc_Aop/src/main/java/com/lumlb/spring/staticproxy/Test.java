package com.lumlb.spring.staticproxy;

public class Test {
	public static void main(String[] args) {
		RealUserService realUserService = new RealUserService();
		ProxyUserService proxyUserService = new ProxyUserService();
		//代理主题角色中持有 真实主题角色的引用 
		proxyUserService.setUserService(realUserService);
		proxyUserService.save();
	}
}
