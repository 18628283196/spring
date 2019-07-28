package com.itheima.service;

import com.itheima.dao.QueryDaoImpl;
import com.itheima.pojo.User;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class QueryServiceImpl implements QueryService {
    public List<User> queryService() throws SQLException {
        QueryDaoImpl qd = new QueryDaoImpl();
        List<User> list = qd.querDao();
        return list;
    }


}
