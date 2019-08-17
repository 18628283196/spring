package com.itheima;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils2 {
    private static DataSource dataSource = new ComboPooledDataSource();

    public static DataSource getDataSource() throws SQLException {

        return  dataSource;
    }
    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }

    public static void closeResource(Connection con , Statement st , ResultSet rs) throws SQLException {
    if(con != null){
        con.close();
    }
        if(st!= null){
            st.close();
        }

        if(rs != null){
            rs.close();
        }

    }

}
