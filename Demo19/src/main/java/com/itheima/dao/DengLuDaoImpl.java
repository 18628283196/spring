package com.itheima.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DengLuDaoImpl implements DengLuDao {
    public void login() {
        System.out.println("登录成功");
    }
}
