package com.itheima.aop_xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * aop基于xml的增强
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Bean.xml")
public class StudentServiceTest {
    @Autowired
    private  StudentService studentService;// 获取代理对象

    @Test
    public void test(){

        studentService.study();
    }
}
