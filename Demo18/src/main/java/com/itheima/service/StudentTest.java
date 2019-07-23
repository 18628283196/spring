package com.itheima.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {
    /**
     * 通过spring来获取对象，看有么有成功设置值
     * 使用set方法赋值
     */
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("BeanFactory.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }

    //通过有参构造来设置参数
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("BeanFactory.xml");
        Student student = context.getBean("student1", Student.class);
        System.out.println(student);
    }

    //通过p空间来设置参数

    /**
     * p空间是对set注入的一种简化操作
     * 要求：1.必须有set方法  2.约束补充一个新的名称空间p   3.配置文件中创建对象，p进行注入
     */
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("BeanFactory.xml");
        Student student = context.getBean("student2", Student.class);
        System.out.println(student);
    }

    //通过c空间来设置参数
    /**
     * c空间主要是用来简化通过构造方法来进行属性赋值
     * 要求：1.必须有构造方法  2.约束补充一个新的名称空间c   3.配置文件中创建对象，c进行注入
     */
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("BeanFactory.xml");
        Student student = context.getBean("student3", Student.class);
        System.out.println(student);
    }

}
