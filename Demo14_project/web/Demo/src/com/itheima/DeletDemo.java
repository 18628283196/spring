package com.itheima;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletDemo {
    public static void main(String[] args) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String s = "delete from product where pname= '神舟'";
        Statement st = con.createStatement();
        int i = st.executeUpdate(s);
        System.out.println(i);
        JDBCUtils.closeResource(con,st,null);
    }
}
