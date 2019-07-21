package com.itheima.aop_xml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * aop基于xml的增强
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Bean1.xml")
public class StudentServiceTest1 {
    @Autowired
    private  StudentService studentService;// 获取代理对象

    @Test
    public void test(){
        //studentService.addStudent();
        //studentService.deleteStudent();
        //studentService.updateStudent();
        //studentService.selectStudent();
        studentService.batchDeleteStudent();//最终通知无论如何它都会执行
    }
}
