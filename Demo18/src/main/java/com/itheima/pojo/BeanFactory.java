package com.itheima.pojo;
//创建实例对象
public class BeanFactory {
    public User findUser(){
        System.out.println("实例工厂对象已被执行");
        return new User();
    }
}
