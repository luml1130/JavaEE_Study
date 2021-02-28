package com.luml.mb.dao;

import com.luml.mb.domain.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserDao extends SqlSessionDaoSupport {
	//SqlSessionTemplate

	public void saveUser(User user){
		this.getSqlSession().insert("com.luml.mb.domain.User.saveUser", user);
	}
}
