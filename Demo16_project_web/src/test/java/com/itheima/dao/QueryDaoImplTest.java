package com.itheima.dao;

import com.itheima.pojo.User;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class QueryDaoImplTest {

    @Test
    public void querDao() throws SQLException {
        QueryDaoImpl qr = new QueryDaoImpl();
        try {
            List<User> list = qr.querDao();
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}