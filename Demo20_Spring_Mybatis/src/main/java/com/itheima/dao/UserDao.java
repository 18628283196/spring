package com.itheima.dao;

import com.itheima.pojo.User;

import java.util.List;

/**
 * 1.根据id查询用户
 * 2.根据name查询用户
 * 3.添加user
 */
public interface UserDao {

    //1.根据id查询用户
    public User findUserById(int id);

    //2.根据name查询用户
    public List<User> findUserByName(String name);

    //3.添加user
    public void inserUser(User user);
}
