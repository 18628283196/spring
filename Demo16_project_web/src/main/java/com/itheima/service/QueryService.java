package com.itheima.service;

import com.itheima.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface QueryService {
    public List<User> queryService() throws SQLException;
}
