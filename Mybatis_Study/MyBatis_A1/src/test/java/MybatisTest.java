package java;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import com.luml.mybatis1.domain.Book;
import com.luml.mybatis1.domain.Order;
import com.luml.mybatis1.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * mybatis操作测试
 * @author luml
 *
 */
public class MybatisTest {
	SqlSessionFactory sessionFactory;
	
	@Before
	public void initSessionFactory() throws Exception{
		String resource = "sqlMapConfig.xml";
		//读取配置文件，返回输入流
		InputStream is = Resources.getResourceAsStream(resource);
		//构建会话工厂对象
		sessionFactory = new SqlSessionFactoryBuilder().build(is);
	}
	
	//根据Id查询User
	@Test
	public void test1() throws Exception{
		String resource = "sqlMapConfig.xml";
		//读取配置文件，返回输入流
		InputStream is = Resources.getResourceAsStream(resource);
		//构建会话工厂对象
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		//从会话工厂中获得一个会话对象
		SqlSession session = sessionFactory.openSession();
		//参数一：使用命名空间+sql语句Id唯一锁定要执行的SQL
		User user = session.selectOne("com.luml.mybatis1.domain.User.selectUserById", 1);
		System.out.println(user);
		session.close();
	}
	
	//查询所有User
	@Test
	public void test2() throws Exception{
		SqlSession session = sessionFactory.openSession();
		System.out.println(session.getClass().getSimpleName());
		List<User> list = session.selectList("com.luml.mybatis1.domain.User.selectAll");
		for (User user : list) {
			System.out.println(user);
		}
		session.close();
	}
	
	//根据Id删除User
	@Test
	public void test3() throws Exception{
		SqlSession session = sessionFactory.openSession();
		//i为执行当前sql影响的数据行数 
		int i = session.delete("com.luml.mybatis1.domain.User.deleteUserById", 1);
		System.out.println(i);
		//提交事务 
		session.commit();
		//关闭会话对象 
		session.close();
	}
	
	//保存User
	@Test
	public void test4() throws Exception{
		SqlSession session = sessionFactory.openSession();
		
		User user = new User("小红","123","北京");
		int i = session.insert("com.luml.mybatis1.domain.User.saveUser", user );
		System.out.println(i);
		//提交事务 
		session.commit();
		//关闭会话对象 
		session.close();
	}
	
	//根据Id修改User
	@Test
	public void test5() throws Exception{
		SqlSession session = sessionFactory.openSession();
		
		User user = new User();
		user.setId(2);
		user.setName("小明");
		
		int i = session.update("com.luml.mybatis1.domain.User.updateUserById", user );
		System.out.println(i);
		//提交事务 
		session.commit();
		//关闭会话对象 
		session.close();
	}
	
	@Test
	public void test6() throws Exception{
		SqlSession session = sessionFactory.openSession();
		
		Book book = session.selectOne("com.luml.mybatis1.domain.Book.selectBookById", "1");
		System.out.println(book);
		
		//关闭会话对象 
		session.close();
	}
	
	//根据查询SQL获取字段名和类型
	@Test
	public void test7() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql:///mybatis_day1";
		String user = "root";
		String password = "root";
		Connection conn = DriverManager.getConnection(url, user, password);
		Statement statement = conn.createStatement();
		String sql = "select * from itcast_book";
		ResultSet rs = statement.executeQuery(sql);
		
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		System.out.println(columnCount);
		
		for(int i=1;i<=columnCount;i++){
			String columnName = metaData.getColumnName(i);
			String type = metaData.getColumnTypeName(i);
			System.out.println("第"+i+"个字段为"+columnName+",类型为"+type);
		}
	}
	
	//根据Id查询Book，返回值类型为Map
	@Test
	public void test8(){
		SqlSession session = sessionFactory.openSession();
		Map<String, Object> map = session.selectOne("com.luml.mybatis1.domain.Book.selectBookById4Map", "1");
		System.out.println(map);
		session.close();
	}
	
	//保存数据，参数类型为Map
	@Test
	public void test9(){
		SqlSession session = sessionFactory.openSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", UUID.randomUUID().toString());
		map.put("name", "mybatis");
		map.put("price", 200D);
		int i = session.insert("com.luml.mybatis1.domain.Book.saveBook4Map", map);
		System.out.println(i);
		session.commit();
		session.close();
	}
	
	//模糊查询
	@Test
	public void test10(){
		SqlSession session = sessionFactory.openSession();
		/*User user = new User();
		user.setName("小");*/
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "小");
		List<User> list = session.selectList("com.luml.mybatis1.domain.User.selectUsersByNameLike", map);
		for (User user2 : list) {
			System.out.println(user2);
		}
		session.close();
	}
	
	//关联查询
	@Test
	public void test11(){
		SqlSession session = sessionFactory.openSession();
		//Customer customer = session.selectOne("com.luml.mybatis1.domain.Customer.selectCustomerById", 1);
		Order order = session.selectOne("com.luml.mybatis1.domain.Order.selectOrderById", 3);
		session.close();
	}
	
	//动态sql----查询
	@Test
	public void test12(){
		SqlSession session = sessionFactory.openSession();
		User user = new User();
		user.setId(2);
		user.setName("ddd");
		List<User> list = session.selectList("com.luml.mybatis1.domain.User.selectUsersByCondition2",user);
		for (User user2 : list) {
			System.out.println(user2);
		}
	}
	
	//动态sql---更新
	@Test
	public void test13(){
		SqlSession session = sessionFactory.openSession();
		User user = new User();
		user.setId(2);
		/*user.setName("ddd");
		user.setPassword("sss");
		user.setAddress("test");*/
		
		int i = session.update("com.luml.mybatis1.domain.User.updateUserByCondition", user);
		System.out.println(i);
		session.commit();
		session.close();
	}
	
	//批量插入数据
	@Test
	public void test14(){
		SqlSession session = sessionFactory.openSession();
		List<User> userList = new ArrayList<User>();
		User user1 = new User("test1", "p1", "addr1");
		userList.add(user1);
		User user2 = new User("test2", "p2", "addr2");
		userList.add(user2);
		User user3 = new User("test3", "p3", "addr3");
		userList.add(user3);
		Map map = new HashMap();
		map.put("userList",userList);
		
		int i = session.insert("com.luml.mybatis1.domain.User.saveUserBatch", map);
		System.out.println(i);
		session.commit();
		session.close();
	}
	
	//批量查询数据
	@Test
	public void test15(){
		SqlSession session = sessionFactory.openSession();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(2);
		ids.add(4);
		ids.add(6);
		Map map = new HashMap();
		map.put("ids",ids);
		
		List<User> list = session.selectList("com.luml.mybatis1.domain.User.selectUsersByIds", map);
		session.close();
	}
}
