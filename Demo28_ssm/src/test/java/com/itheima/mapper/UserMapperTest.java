package com.itheima.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper mapper;
    @Test
    public void transferIn() {
       /* mapper.transferIn("jack" ,500);*/
       mapper.transferIn("jack",200);
    }

    @Test
    public void transferOut() {
        mapper.transferOut("rose",500);
    }
}