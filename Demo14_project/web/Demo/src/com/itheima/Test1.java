package com.itheima;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test1 {
    @Test
    //给数据库添加数据
    public void method() throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String s = "insert into category values (?,?)";
        PreparedStatement pt = con.prepareStatement(s);
        pt.setString(1,"c004");
        pt.setString(2,"文具");
        int i = pt.executeUpdate();
        System.out.println("返回值:"+i);
        JDBCUtils.closeResource(con,pt,null);
    }
@Test
    //给数据库修改数据
public void method1() throws SQLException {
    Connection con = JDBCUtils.getConnection();
    String s = "update category set cname =? where cid = ?";
    PreparedStatement pt = con.prepareStatement(s);
    pt.setString(1,"安全");
    pt.setString(2,"c004");
    int i = pt.executeUpdate();
    System.out.println("返回值:"+i);
    JDBCUtils.closeResource(con,pt,null);
}
    @Test
    //删除一列数据
    public void method2() throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String s = "delete from category where cid = ? and cname = ?";
        PreparedStatement pt = con.prepareStatement(s);
        pt.setString(1,"c004");
       pt.setString(2,"安全");
        int i = pt.executeUpdate();
        System.out.println("返回值:"+i);
        JDBCUtils.closeResource(con,pt,null);
    }



}
