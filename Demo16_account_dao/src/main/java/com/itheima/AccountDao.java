package com.itheima;

import java.sql.Connection;
import java.sql.SQLException;

public interface AccountDao {
    //转钱  两个方法：转入 和 转出
    //转入
    public void transferIn(Connection connection,String name, double money) throws SQLException;
    //转出
    public void transferOut(Connection connection,String name,double money) throws SQLException;
}
