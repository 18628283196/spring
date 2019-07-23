package com.itheima.pojo;
//通过三种方式创建user对象


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1.构造方法创建对象----测试
 *
 *
 * 2.静态工厂对象创建对象----测试
 *
 *
 * 3.实例工厂创建对象
 */
public class UserTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        User user_1 = context.getBean("user_1", User.class);
        

    }
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        User user_2 = context.getBean("user_2", User.class);
    }
    @Test
    //实例工厂创建对象
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        User user_3 = context.getBean("user_3", User.class);
    }

}
