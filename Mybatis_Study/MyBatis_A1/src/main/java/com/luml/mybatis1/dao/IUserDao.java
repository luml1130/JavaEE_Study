package com.luml.mybatis1.dao;

import com.luml.mybatis1.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;


public interface IUserDao {

	@Select(value="select * from mybaits_user where id = #{id}")
	public User findUserById(Integer id);
	
	@Delete("delete from mybaits_user where id = #{id}")
	public void deleteUserById(Integer id);
}
