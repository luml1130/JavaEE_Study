package com.lumlb.spring.jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * 测试使用jdbc模板
 * @author Andre 2017年7月16日
 */
public class JdbcTemplateTest {

	/**
	 * 插入数据
	 */
	@Test
	public void test1(){
		//读取spring配置文件，初始化spring工厂
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lumlb/spring/jdbcTemplate/beans.xml");
		JdbcTemplate template = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		//HibernateTemplate template=  (HibernateTemplate) ctx.getBean("HibernateTemplate");
		String sql = "insert into springD2_user(name,age,address) values (?,?,?)";
		template.update(sql,"张三",30,"北京");
		/*springD2_user d2_user = new springD2_user();
		d2_user.setName("鲁孟良");
		d2_user.setAge(27);
		d2_user.setAddress("河南");
		template.update(d2_user);*/
	}
	
	/**
	 * 修改数据
	 */
	@Test
	public void test2(){
		//读取spring配置文件，初始化spring工厂
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lumlb/spring/jdbcTemplate/beans.xml");
		JdbcTemplate template = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		String sql = "update springD2_user set name = ? where id = ?";
		template.update(sql,"李四",1);
	}
	

	/**
	 * 删除数据
	 */
	@Test
	public void test3(){
		//读取spring配置文件，初始化spring工厂
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lumlb/spring/jdbcTemplate/beans.xml");
		JdbcTemplate template = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		String sql = "delete from springD2_user where id = ?";
		template.update(sql,2);
	}
	

	/**
	 * 查询
	 */
	@Test
	public void test4(){
		//读取spring配置文件，初始化spring工厂
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lumlb/spring/jdbcTemplate/beans.xml");
		JdbcTemplate template = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		String sql = "select count(id) from springD2_user";
		int count = template.queryForInt(sql);
		System.out.println(count);
		
		sql = "select name from springD2_user where id = ?";
		String name = template.queryForObject(sql, String.class,1);
		System.out.println(name);
	}
	
	/**
	 * 查询单个对象
	 */
	@Test
	public void test5(){
		//读取spring配置文件，初始化spring工厂
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lumlb/spring/jdbcTemplate/beans.xml");
		JdbcTemplate template = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		String sql = "select * from springD2_user where id = ?";
		springD2_user springD2_user = template.queryForObject(sql, new RowMapper<springD2_user>(){
			/**
			 * 手动将从数据库中查询出的结果ResultSet映射为一个User对象
			 */
			public springD2_user mapRow(ResultSet rs, int index) throws SQLException {
				springD2_user springD2_user = new springD2_user();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				
				springD2_user.setId(id);
				springD2_user.setName(name);
				springD2_user.setAge(age);
				springD2_user.setAddress(address);
				return springD2_user;
			}
		},1);
		System.out.println(springD2_user);
	}

	/**
	 * 查询List集合
	 */
	@Test
	public void test6(){
		//读取spring配置文件，初始化spring工厂
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lumlb/spring/jdbcTemplate/beans.xml");
		JdbcTemplate template = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		String sql = "select * from user";
		List<springD2_user> userList = template.query(sql, new RowMapper<springD2_user>(){
			/**
			 * 手动将从数据库中查询出的结果ResultSet映射为一个User对象
			 */
			public springD2_user mapRow(ResultSet rs, int index) throws SQLException {
				springD2_user springD2_user = new springD2_user();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				
				springD2_user.setId(id);
				springD2_user.setName(name);
				springD2_user.setAge(age);
				springD2_user.setAddress(address);
				return springD2_user;
			}
		});
		for(springD2_user springD2_user:userList){
			System.out.println(springD2_user);
		}
	}
	

	/**
	 * 使用JdbcDaoSupport
	 */
	@Test
	public void test7(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lumlb/spring/jdbcTemplate/beans.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		springD2_user springD2_user= new springD2_user();
		springD2_user.setName("test");
		userDao.saveUser(springD2_user);
	}
}
