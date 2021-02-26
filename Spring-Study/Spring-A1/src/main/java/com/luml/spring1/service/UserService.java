package com.luml.spring1.service;

import com.luml.spring1.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service   //<bean id="" class="">
//@Scope("prototype")//设置bean的作用域
public class UserService {
	
	//@Resource//(name="userDao")
	@Autowired
	private UserDao userDao;
	
/*	@Autowired
	@Qualifier(value="userDao")//指定注入名称为userDao的对象
	private UserDao userDao;*/
	
	public UserService() {
		System.out.println("UserService无参构造方法。。。");
	}
	
	public void save(){
		//System.out.println("保存操作。。。");
		userDao.save();
	}
}
