package com.itheima.dao;

import com.itheima.pojo.Employee;
import com.itheima.pojo.user;
import sun.invoke.empty.Empty;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public interface AddProduct {
    //添加全查询方法
    public List<user> addAll() throws SQLException;
    //通过id删除用户
    public int delet(int eid) throws SQLException;
    //添加用户信息
    public void add(Employee emp) throws SQLException;
    //通过id查询员工用于回显数据
    public user updateDao(int id) throws SQLException;
    //修改数据
    public void updatedao(user use) throws SQLException;
    //批量删除
    void deletAll(Connection connection, int eid) throws SQLException;
    //查询总记录数
    Long queryTotal() throws SQLException;
    //查询一页数据
    List<user> findEmpDept(Long index, int rows) throws SQLException;
}
