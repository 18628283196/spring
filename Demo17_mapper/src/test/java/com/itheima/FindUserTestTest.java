package com.itheima;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FindUserTestTest {
    SqlSessionFactory factory = null;
    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //获取接口代理对象 getMapp(接口的字节码对象)
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = builder.build(inputStream);
    }

    //查询一条用户
    @Test
    public void findUserById() {
        SqlSession sqlSession = factory.openSession();
        FindUserTest mapper = sqlSession.getMapper(FindUserTest.class);
        User user = mapper.findUserById(3);
        System.out.println(user);
    }

    //模糊查询
    @Test
    public void findUserByName() {
        SqlSession sqlSession = factory.openSession();
        FindUserTest mapper = sqlSession.getMapper(FindUserTest.class);
        List<User> list = mapper.findUserByName("zhang");
        System.out.println(list);
    }

    //添加用户信息
    @Test
    public void insertUser() {
        SqlSession sqlSession = factory.openSession(true);
        FindUserTest mapper = sqlSession.getMapper(FindUserTest.class);
        User user = new User();
        user.setUid(25);
        user.setAge(18);
        user.setAdress("上海");
        user.setEameil("15465@163.com");
        user.setName("z张三");
        user.setQq("55852355");
        user.setSex("男");
       mapper.insertUser(user);
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = factory.openSession(true);
        FindUserTest mapper = sqlSession.getMapper(FindUserTest.class);
        User user = new User();
        user.setUid(1);
        user.setAge(18);
        user.setAdress("上海");
        user.setEameil("15465@163.com");
        user.setName("z张三");
        user.setQq("55852355");
        user.setSex("男");
        mapper.updateUser(user);

    }

    @Test
    public void deleteUserById() {
        SqlSession sqlSession = factory.openSession(true);
        FindUserTest mapper = sqlSession.getMapper(FindUserTest.class);
        mapper.deleteUserById(1);
    }


    //根据name和sex查询
    //如果name没传递，只根据sex查询；如果sex没传递，只根据name查询；如果name和sex都没传，全查询
   @Test
    public void findUserByNameAndSexTest(){
        SqlSession sqlSession = factory.openSession();
        FindUserTest mapper = sqlSession.getMapper(FindUserTest.class);
        List<User> list = mapper.findUserByNameAndSex("zhang","man");
        System.out.println(list);
    }
    //在id范围内查找指定的用户
    @Test
    public void findUserByAllId(){
        SqlSession sqlSession = factory.openSession();
        FindUserTest mapper = sqlSession.getMapper(FindUserTest.class);
         List<Integer> list = new ArrayList<Integer>();
         list.add(3);
         list.add(4);
         list.add(5);
        List<User> list1 = mapper.findUserByAllId(list);
        System.out.println(list1);
    }

    @Test
    public void queryOrderAndUser(){
        SqlSession sqlSession = factory.openSession();
        FindUserTest mapper = sqlSession.getMapper(FindUserTest.class);
        List<Order> list = mapper.queryOrderAndUser();
        System.out.println(list);
    }


}