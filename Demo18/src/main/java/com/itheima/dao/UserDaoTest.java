package com.itheima.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest {
    @Test
    public void test(){
        UserDaoImpl ud = new UserDaoImpl();
        ud.setName("张三");
        ud.findUser();
    }

    //Spring调用
    @Test
    public void test1(){
        //加载spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
       //根据配置文件的id获取 一个UserDaoImpl对象
        UserDaoImpl user = context.getBean("user", UserDaoImpl.class);
        //调用方法
        user.findUser();
    }
}
