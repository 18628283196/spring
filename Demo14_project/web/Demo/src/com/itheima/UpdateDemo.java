package com.itheima;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDemo {
    public static void main(String[] args) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String s = "update product set pname = '神舟',price = 8000 where pid = 1";
        Statement st = con.createStatement();
        int i = st.executeUpdate(s);
        System.out.println(i);
        JDBCUtils.closeResource(con,st,null);



    }
}
