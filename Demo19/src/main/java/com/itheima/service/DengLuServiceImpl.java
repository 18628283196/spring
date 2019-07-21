package com.itheima.service;

import com.itheima.dao.DengLuDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DengLuServiceImpl implements DengLuService {
    @Autowired
    private DengLuDaoImpl dao;
    public void loginService() {
        System.out.println("正在登录");
        dao.login();
    }
}
