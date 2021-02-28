package com.luml.mb.service;

import com.luml.mb.dao.UserDao;
import com.luml.mb.domain.User;

public class UserService implements IUserService {
	private UserDao userDao;
	@Override
	public void saveUser(User user){
		userDao.saveUser(user);
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
