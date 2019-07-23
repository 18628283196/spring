package com.itheima.pojo;
//创建一个静态工厂对象
public class StaticFactory {
    public static User getUser(){
        System.out.println("静态工厂对象方法已执行");
        return new User();
    }
}
