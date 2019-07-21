package com.itheima.test;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * spring针对与简化测试给了解决方案：spring-test.jar   junit.jar
 * 提供了两个注解：添加到测试类上  --加载的内容就可以省略
 * @RunWith 以什么方式运行  SpringJUnit4ClassRunner.class 以spring提供的Junit来运行
 * @ContextConfiguration上下文配置环境，可以加载spring核心配置文件
 *
 */
// @RunWith 以什么方式运行  SpringJUnit4ClassRunner.class 以spring提供的Junit来运行
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration上下文配置环境，可以加载spring核心配置文件
@ContextConfiguration("classpath:ApplicationContext.xml")
public class PersonContextTest {
   @Test
    public void test(){
       ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
       PersonServlet personServlet = context.getBean("personServlet", PersonServlet.class);
       personServlet.person();
   }

   @Autowired
   private PersonServlet person1;

   @Test
   public void test1(){
       person1.person();
   }
}
