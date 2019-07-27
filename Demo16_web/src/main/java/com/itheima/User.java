package com.itheima;


import lombok.Data;

//lombok可以代替一下参数
//1.无参构造  2.setter和getter方法   3.toString
@Data
public class User {
    private String name;
    private int age;
    private String sex;
}
