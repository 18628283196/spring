package com.itheima.dao;

import com.itheima.dbutils.JDBCUtils;
import com.itheima.pojo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class QueryDaoImpl implements QueryDao {
    public List<User> querDao() throws SQLException {
        DataSource datasource = JDBCUtils.getDatasource();
        QueryRunner qr = new QueryRunner(datasource);
        List<User> list = qr.query("select * from user", new BeanListHandler<User>(User.class));
        return list;
    }

}
