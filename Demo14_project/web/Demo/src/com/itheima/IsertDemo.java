package com.itheima;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class IsertDemo {
    public static void main(String[] args) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String s = "insert into product values(14,'华硕', 5000)";
        Statement st = con.createStatement();
        int i = st.executeUpdate(s);
        System.out.println(i);
        JDBCUtils.closeResource(con,st,null);
    }
}
