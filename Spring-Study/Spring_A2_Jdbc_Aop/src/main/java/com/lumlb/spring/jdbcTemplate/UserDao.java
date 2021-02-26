package com.lumlb.spring.jdbcTemplate;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author luml
 */
public class UserDao extends JdbcDaoSupport{
	
	public void saveUser(springD2_user springD2_user){
		String sql = "insert into springD2_user(name,age,address) values (?,?,?)";
		this.getJdbcTemplate().update(sql,springD2_user.getName(),springD2_user.getAge(),springD2_user.getAddress());
	}
}
