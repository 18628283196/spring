package com.itheima.dao;

import com.itheima.pojo.Employee;
import com.itheima.pojo.user;
import com.itheima.utils.JDBCUtils2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * eid INT PRIMARY KEY AUTO_INCREMENT,
 ename VARCHAR(20),
 sex VARCHAR(6),
 tel VARCHAR(20),
 email VARCHAR(50),
 address VARCHAR(200),
 did INT   #外键
 dname VARCHAR(30)
 */

public class AddProductImpl implements AddProduct {
    private DataSource datasource = JDBCUtils2.getDataSource();
    private QueryRunner qr = new QueryRunner(datasource);

    public AddProductImpl() throws SQLException {
    }

    @Override
    public List<user> addAll() throws SQLException {
        List<user> list = qr.query("select eid,ename,sex,tel,email,address,e.did,dname,photo from emp e,dept d where e.did=d.did order by eid asc", new BeanListHandler<user>(user.class));
        return list;
    }

    @Override
    public int delet(int id) throws SQLException {
        int i = qr.update("delete from emp where  eid=? ", id);
        return i;
    }

    //添加修改员工信息
    @Override
    public void add(Employee emp) throws SQLException {
        qr.update("insert into emp values (null,?,?,?,?,?,?,?)",emp.getEname(),emp.getSex(),emp.getTel(),emp.getEmail(),emp.getAddress(),emp.getDid(),emp.getPhoto());
    }

    @Override
    public user updateDao(int id) throws SQLException {
        user list = qr.query("SELECT eid,ename,sex,tel,email,address,dname,e.did FROM emp e,dept d WHERE  e.did=d.did AND eid =?;  ", new BeanHandler<user>(user.class), id);
        return list;
    }

    //修改员工信息
    @Override
    public void updatedao(user use) throws SQLException {
        qr.update("update emp set ename=?,sex=?,tel=?,email=?,address=?,did=? where eid=? ",use.getEname(),use.getSex(),use.getTel(),use.getEmail(),use.getAddress(),use.getDid(),use.getEid());
    }

    //通过id删除信息
    @Override
    public void deletAll(Connection connection, int eid) throws SQLException {
         qr.update("delete from emp where  eid=? ", eid);
    }
    //查询总记录数
    @Override
    public Long queryTotal() throws SQLException {
        Long total = (Long)qr.query("select count(*) from emp", new ScalarHandler());
        return total;
    }
    //查询一页数据
    @Override
    public List<user> findEmpDept(Long index, int rows) throws SQLException {
        List<user> list = qr.query("SELECT eid,ename,sex,tel,email,address,e.did,dname,photo FROM emp e,dept d WHERE  e.did=d.did   LIMIT ? , ?;", new BeanListHandler<user>(user.class), index, rows);
        return list;
    }

    @Test
    public  void test() throws SQLException {
        //List<user> list = addAll();
       // delet(1);
        //System.out.println(list);
        /*user list = updateDao(9);
        System.out.println(list);*/
        List<user> list = addAll();
        System.out.println(list);
    }


}
