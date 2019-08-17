package com.itheima.service;

import com.itheima.pojo.Employee;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.user;

import java.sql.SQLException;
import java.util.List;

public interface AllQuery {
    //全查询
    public List<user> queryAll() throws SQLException;
    //根据id删除员工
    public int delete(int id) throws SQLException;
    //添加员工信息
    public void addAll(Employee emp) throws SQLException;
    //根据id查询员工信息
    public user queryService(int id) throws SQLException;
    //修改数据
    public void queryService(user use) throws SQLException;

    public int deleteAllById(String dir) throws SQLException;
    //分页查询方法

    PageBean findPageBean(Long currentPage,int rows) throws SQLException;
}
