package com.itheima.mapper;

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
@ContextConfiguration("classpath:applicationContext1.xml")
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findUserById() {
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void findUserByName() {
        List<User> list = userMapper.findUserByName("王五");
        System.out.println(list);
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setUsername("王丽坤");
        user.setSex("女");
        user.setAddress("成都");
        user.setBirthday(new Date());
        userMapper.insertUser(user);

    }
}