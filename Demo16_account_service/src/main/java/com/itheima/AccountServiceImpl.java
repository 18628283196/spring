package com.itheima;

import com.itheima.dbutils.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {
    @Override
    public void transfer(String inName, String outName, double money)  {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            AccountDaoImpl ad = new AccountDaoImpl();
            ad.transferIn(connection,inName,money);
           int i = 1/0;
            ad.transferOut(connection,outName,money);
            connection.commit();
            System.out.println("转账成功");
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            System.out.println("转账失败");
            e.printStackTrace();
        }
    }
}
