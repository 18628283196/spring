package com.itheima;

import java.sql.*;

public class   JDBCUtils {
   private  JDBCUtils(){};
    public static String url = "jdbc:mysql:///day_01";
    private static String username = "root";
    private static String password = "root";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(url,username,password);
        return con;
    }
    public static void closeResource(Connection con, Statement st, ResultSet rs) throws SQLException {
    if(rs != null){
        rs.close();
    }
    if(st != null){
        st.close();
    }
    if(rs != null){
        rs.close();
    }
    }


    }


