package com.itheima;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String s ="select * from person";
        Statement st = con.createStatement();
        ResultSet s1 = st.executeQuery(s);
        while(s1.next()){
            int a = s1.getInt("pid");
            String name = s1.getString("name");
            int age = s1.getInt("age");

            String addrees = s1.getString("addrees");
            System.out.println(a+"  " +name +"  "+ age +"  " +addrees);

        }
        JDBCUtils.closeResource(con,st,s1);


    }
}
