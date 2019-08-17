package com.itheima;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreperstatementDemo{
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String s = sc.nextLine();
        System.out.println("请输入用户密码");
        String s1 = sc.nextLine();
        //创建连接数据库
        Connection con = JDBCUtils.getConnection();
        //编写SQL语句
        String sql = "select * from user where usename=? AND password=? ";
        //预编译
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1,s);
        pt.setString(2,s1);

        ResultSet rs = pt.executeQuery();
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }


    }
}
