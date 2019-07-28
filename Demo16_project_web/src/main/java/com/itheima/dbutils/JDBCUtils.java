package com.itheima.dbutils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtils {
    public  static DataSource dataSource = new ComboPooledDataSource();
    public static DataSource getDatasource(){
        return dataSource ;
    }
    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return getConnection();
    }
}
