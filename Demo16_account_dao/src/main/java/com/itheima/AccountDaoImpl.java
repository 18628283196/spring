package com.itheima;

import com.itheima.dbutils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void transferIn(Connection connection, String name, double money) throws SQLException {
        DataSource dataSource = JDBCUtils.getDataSource();
        QueryRunner qr = new QueryRunner(dataSource);
         qr.update("update account set money =money + ? where name = ? ", money, name);
    }

    @Override
    public void transferOut(Connection connection,String name, double money) throws SQLException {
        DataSource dataSource = JDBCUtils.getDataSource();
        QueryRunner qr = new QueryRunner(dataSource);
        qr.update("update account set money = money - ? where name = ? ", money, name);
    }

}
