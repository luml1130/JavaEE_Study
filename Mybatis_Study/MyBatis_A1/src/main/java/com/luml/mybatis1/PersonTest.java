package com.luml.mybatis1;

import com.luml.mybatis1.domain.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author luml
 * @description
 * @date 2021/3/1 9:36 上午
 */
public class PersonTest {
    /**
     * 创建session工厂
     */
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    /**
     * 根据id查询person
     * @author:任亮
     * @email:renliang@itcast.com
     * @qq交流群:208879353
     * @company：cn.itcast
     */
    @Test
    public void selectPersonById() {
        //创建session
        SqlSession session = sqlSessionFactory.openSession();
        try {
            //第一个参数namespace+"."+sql的id，第二个参数就是sql所需要的参数
            Order order = session.selectOne("com.luml.mybatis1.domain.Order.selectOrderById", 1);
            System.out.println(order);
            session.close();
        }finally {
            //关闭连接
            session.close();
        }
    }
}
