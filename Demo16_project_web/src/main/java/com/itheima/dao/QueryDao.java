package com.itheima.dao;

import com.itheima.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface QueryDao {
    public List<User> querDao() throws SQLException;
}
