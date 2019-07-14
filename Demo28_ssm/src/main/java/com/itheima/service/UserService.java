package com.itheima.service;

import com.itheima.pojo.PageBean;
import com.itheima.pojo.User;
import com.itheima.pojo.User1;


public interface UserService {
    //分页查询PageBean
    public PageBean findPageBean(int pageNum,int rowsNum);

    void addUser(User1 user);
}
