package com.itheima.dao;

import com.itheima.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoTest {

    @Autowired
    private UserDaoImpl userDao;
    @Test
    public void findUserById() {
        User user = userDao.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void findUserByName() {
        List<User> user = userDao.findUserByName("张三");
        System.out.println(user);

    }

    @Test
    public void inserUser() {
        User user = new User();
        user.setUsername("王丽坤");
        user.setSex("女");
        user.setAddress("成都");
        user.setBirthday(new Date());
        userDao.inserUser(user);
    }
}