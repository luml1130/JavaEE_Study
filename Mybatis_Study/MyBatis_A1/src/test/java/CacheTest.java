import java.io.IOException;
import java.io.InputStream;

import com.luml.mybatis1.dao.IUserDao;
import com.luml.mybatis1.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * 缓存测试 
 * @author luml
 */
public class CacheTest {

	@Test
	public void test() throws  Exception{
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = sessionFactory.openSession();

		//获得cityDao对象
		IUserDao userDao = sqlSession.getMapper(IUserDao.class);
		User user001 = userDao.findUserById(1);
		System.out.println(user001);
		System.out.println("-------------------------------------");

		//再次查询CityDO对象，因为是同一个SqlSession,所以会从之前的一级缓存中查找数据
		User user002 = userDao.findUserById(1);
		System.out.println(user002);
		System.out.println("-------------------------------------");
		sqlSession.close();
	}
	
	//测试一级缓存的存在，和生命周期
	@Test
	public void test1() throws Exception{
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		
		//会发出sql查询数据库，将User载入一级缓存
		User user1 = session.selectOne("com.luml.mybatis1.domain.User.selectUserById", 1);
		
		//不会发出sql，直接从一级缓存中获取数据
		User user2 = session.selectOne("com.luml.mybatis1.domain.User.selectUserById", 1);
		
		System.out.println(user1 == user2);
		//Session关闭，一级缓存消失
		session.close();
		
		session = sessionFactory.openSession();
		//发出sql查询数据库，一级缓存已经消失
		User user3 = session.selectOne("com.luml.mybatis1.domain.User.selectUserById", 3);
		session.close();
	}
	
	//测试二级缓存的存在,二级缓存的生命周期就是sessionFactory的生命周期
	@Test
	public void test2() throws Exception{
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		
		//发出sql
		User user1 = session.selectOne("com.luml.mybatis.domain.User.selectUserById", 3);
		//不会发出sql，从一级缓存中获取数据 
		User user2 = session.selectOne("com.luml.mybatis.domain.User.selectUserById", 3);
		
		//一级缓存消失
		session.close();
		
		session = sessionFactory.openSession();
		//不会发出sql，从二级缓存中获取数据 
		User user3 = session.selectOne("com.luml.mybatis.domain.User.selectUserById", 3);
		session.close();
		
		//重新获取一个会话工厂对象
		in = Resources.getResourceAsStream("sqlMapConfig.xml");
		sessionFactory = new SqlSessionFactoryBuilder().build(in);
		session = sessionFactory.openSession();
		User user4 = session.selectOne("cn.itcast.domain.User.selectUserById", 3);
		session.close();
	}
	
	@Test
	public void test3() throws Exception{
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		
		//会发出sql查询数据库，将User载入一级缓存
		User user1 = session.selectOne("com.luml.mybatis.domain.User.selectUserById", 3);
		
		//不会发出sql，直接从一级缓存中获取数据
		User user2 = session.selectOne("com.luml.mybatis.domain.User.selectUserById", 3);
		
		System.out.println(user1 == user2);
		//Session关闭，一级缓存消失
		session.close();
		
		session = sessionFactory.openSession();
		//发出sql查询数据库，一级缓存已经消失
		User user3 = session.selectOne("com.luml.mybatis.domain.User.selectUserById", 3);
		session.close();
	}
}
