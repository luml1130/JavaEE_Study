package com.luml.mybatis1;

import java.io.InputStream;

import com.luml.mybatis1.dao.IUserDao;
import com.luml.mybatis1.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author luml
 */
public class MybatisAnnotationTest {
	public static void main(String[] args) throws Exception {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		
		IUserDao userDao = session.getMapper(IUserDao.class);
		User user = userDao.findUserById(1);
		System.out.println(user);
		
		//userDao.deleteUserById(2);
		session.commit();
	}
}
