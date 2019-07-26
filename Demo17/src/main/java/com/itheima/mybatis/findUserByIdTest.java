package com.itheima.mybatis;

import com.itheima.user.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class findUserByIdTest {
    @Test
    public void findUserById() throws IOException {
        //获取sqlSessionFactorBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //以流的方式加载核心配置文件sqlSessionConfig
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //sqlSessionFactoryBuilder 调用build方法读取流并创建一个sqlSessionFactory
        SqlSessionFactory factory = builder.build(in);
        //sqlSessionFactory 调用openSession方法获取到一个sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //调用sqlSession对象的selectone（“名称空间.sql的id",具体的id）==具体的user的对象
        User user = sqlSession.selectOne("test.findUserById", 2);
        //打印
        System.out.println(user);
        //关闭流和sqlSession对象
        in.close();
        sqlSession.close();

    }

    //模糊查询方式一
    @Test
    public void findUserByNameTest() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession();
        List<User> user = sqlSession.selectList("test.findUserByName", "%zhang%");
        System.out.println(user);
        inputStream.close();
        sqlSession.close();
    }


    //模糊查询方式二
    @Test
    public void findUserByName2Test() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession();
        List<User> user = sqlSession.selectList("test.findUserByName2", "郭");
        System.out.println(user);
        inputStream.close();
        sqlSession.close();
    }

    //添加用户
    @Test
    public void insertUserTest() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession(true);//添加修改true，自动提交事务，增删改都需要设置为true
        User user = new User();
        user.setUid(2);
        user.setAge(18);
        user.setAdress("上海");
        user.setEameil("15465@163.com");
        user.setName("z张三");
        user.setQq("55852355");
        user.setSex("男");
        sqlSession.insert("test.insertUser",user);
        inputStream.close();
        sqlSession.close();
    }

    //修改用户
    @Test
    public void updateUserTest() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession(true);//添加修改true，自动提交事务，增删改都需要设置为true
        User user = new User();
        user.setUid(1);
        user.setAge(20);
        user.setName("李四");
        user.setSex("女");
        sqlSession.insert("test.updateUser",user);
        inputStream.close();
        sqlSession.close();
    }

    //根据id删除用户
    @Test
    public void deleteUserById() throws IOException {
        //获取sqlSessionFactorBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //以流的方式加载核心配置文件sqlSessionConfig
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //sqlSessionFactoryBuilder 调用build方法读取流并创建一个sqlSessionFactory
        SqlSessionFactory factory = builder.build(in);
        //sqlSessionFactory 调用openSession方法获取到一个sqlSession对象
        SqlSession sqlSession = factory.openSession(true);
        //调用sqlSession对象的selectone（“名称空间.sql的id",具体的id）==具体的user的对象
        User user = sqlSession.selectOne("test.deleteUserById", 2);
        //关闭流和sqlSession对象
        in.close();
        sqlSession.close();

    }
}
