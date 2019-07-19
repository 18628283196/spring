package com.itheima.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 1.创建连接池===DriveManagerDataSource
 *              ----设置数据库的连接信息  驱动   数据库URL  用户名  密码
 *  2.创建Template对象
 *        构造JdbcTemplate(DataSource)
 *
 *  3.调用update的方法完成增删改的操作
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class JdbcTemplateDemo {
    @Test
    public void test(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///day24");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //创建jdbctemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //调用update的方法完成增删改的操作
        //INSERT INTO `stu` (`sid`, `sname`, `schoolName`, `score`) VALUES('19','张飞','交大','3000');
        jdbcTemplate.update("insert into stu values(?,?,?,?)",2,"尼古拉斯","西南财经",700);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //添加用户信息
    @Test
    public void test1(){

        jdbcTemplate.update("insert into stu values(?,?,?,?)",6,"张天爱","女神姐姐",15000);
    }

    //修改用户信息
    @Test
    public void test2(){
        //sid`, `sname`, `schoolName`, `score`
        jdbcTemplate.update("update stu set sname = ?,schoolName = ? , score = ? where sid = ?","祖尔","小姐姐",16000,6);
    }

    //删除用户信息
    @Test
    public void test3(){

        jdbcTemplate.update("delete from stu where sid = ?",17);
    }

}
