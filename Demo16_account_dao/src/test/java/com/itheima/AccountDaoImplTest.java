package com.itheima;

import com.itheima.dbutils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class AccountDaoImplTest {

    @org.junit.Test
    public void transferIn() throws SQLException {
        AccountDaoImpl aa = new AccountDaoImpl();
        try {
            Connection connection = JDBCUtils.getConnection();
            aa.transferIn(connection,"jack",500);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void transferOut() {
        AccountDaoImpl aa = new AccountDaoImpl();
        try {
            Connection connection = JDBCUtils.getConnection();
            aa.transferOut(connection,"rose",500);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}