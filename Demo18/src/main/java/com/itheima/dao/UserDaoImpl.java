package com.itheima.dao;

public class UserDaoImpl implements UserDao {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void findUser() {
        System.out.println("User对象"+name);

    }
}
