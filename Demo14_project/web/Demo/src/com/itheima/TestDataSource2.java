package com.itheima;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDataSource2 {
    @Test
    //对数据了进行增加元素内容
    public  void method() throws SQLException {
        Connection con = JDBCUtils2.getConnection();
        String s = "insert into product values (?,?)";
        PreparedStatement pt = con.prepareStatement(s);
        pt.setString(1,"战神");
        pt.setString(2,"6000");
        int i = pt.executeUpdate();
        System.out.println(i);
        JDBCUtils2.closeResource(con,pt,null);
    }
    @Test
    //对数据库进行修改
    public  void method1() throws SQLException {
        Connection con = JDBCUtils2.getConnection();
        String s = "update product set price = ? where pname = ?";
        PreparedStatement pt = con.prepareStatement(s);
        pt.setString(1,"18000");
        pt.setString(2,"战神");
        int i = pt.executeUpdate();
        System.out.println(i);
        JDBCUtils2.closeResource(con,pt,null);
    }
    @Test
    //对数据库进行删除
    public  void method2() throws SQLException {
        Connection con = JDBCUtils2.getConnection();
        String s = "delete from product where pname = ? and price = ?";
        PreparedStatement pt = con.prepareStatement(s);
        pt.setString(1,"战神");
        pt.setString(2,"18000");
        int i = pt.executeUpdate();
        System.out.println(i);
        JDBCUtils2.closeResource(con,pt,null);
    }
    @Test
    //查询数据库
    public  void method3() throws SQLException {
        Connection con = JDBCUtils2.getConnection();
        String s = "select * from product ";
        PreparedStatement pt = con.prepareStatement(s);
        //pt.setString(1,"18000");
        //pt.setString(2,"战神");
        ResultSet rs =pt.executeQuery();
        // System.out.println(i);
        while(rs.next()){
            String pname = rs.getString("pname");
            String price = rs.getString("price");
            System.out.println(pname+"  "+ price);
        }
        JDBCUtils2.closeResource(con,pt,rs);
    }
}
