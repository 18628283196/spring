package com.itheima;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
    实现步骤：
    1.导入mysql的驱动jar包 和c3p0的jar
    2.在src目录下创建一个c3p0-config.xml文件
    3.main方法中创建连接池对象
    4.调用getConnection()方法来获取连接池对象
    5.编写SQL
    6.获取语句执行对象
    7.执行sql
    8.遍历结果集
    9.关闭资源
 */
public class DemoC3p0 {
    public static void main(String[] args) throws SQLException {
        //main方法中创建连接池对象
        DataSource ds = new ComboPooledDataSource();
        // 调用getConnection()方法来获取连接池对象
        Connection con = ds.getConnection();
        //编写SQL
        String s = "select * from product   ";
        //获取语句执行对象
        PreparedStatement pt = con.prepareStatement(s);
        //执行sql
        ResultSet rs = pt.executeQuery();
        while (rs.next()){
            String cid = rs.getString("pname");
            String cname = rs.getString("price");

            System.out.println(cid + "   "+cname);

        }
        rs.close();
        pt.close();
        con.close();
    }
}
