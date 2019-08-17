package com.itheima;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDataSource {
    public static void main(String[] args) throws SQLException {
       // DataSource datasuorce = JDBCUtils2.getDatasuorce();
        Connection con = JDBCUtils2.getConnection();
        String s = "select * from product";
        PreparedStatement pt = con.prepareStatement(s);
        ResultSet rs = pt.executeQuery();
        while (rs.next()){
            String pname = rs.getString("pname");
            String price = rs.getString("price");
            System.out.println(pname + "  "+price);
        }
        JDBCUtils2.closeResource(con,pt,rs);
    }
}
