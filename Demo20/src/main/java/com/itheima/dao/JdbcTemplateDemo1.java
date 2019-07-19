package com.itheima.dao;

import com.itheima.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * 1.根据id查询学生name
 * 2.查询一共有多少学生
 * 3.查询id为4的Student对象，返回Student对象
 * 4.查询id为3的Student对象返回map
 * 5.查询所有Student对象  返回List<map<String,Object>> queryForList
 * 6.查询所有学生返回一个List<Student>对象
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class JdbcTemplateDemo1 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //根据id查询学生name
    @Test
    public void queryByName(){
        String user = jdbcTemplate.queryForObject("select sname from stu where sid = ?", String.class, 1);
        System.out.println(user);
    }
    // 2.查询一共有多少学生
    @Test
    public void countUser(){
        Integer count = jdbcTemplate.queryForObject("select count(*) from stu", Integer.class);
        System.out.println(count);
    }

    //3.查询id为4的Student对象，返回Student对象
    @Test
    public void queryStudentById(){
        Student student = jdbcTemplate.queryForObject("select * from stu where sid = ?", new BeanPropertyRowMapper<Student>(Student.class), 3);
        System.out.println(student);
    }
    // 4.查询id为3的Student对象返回map
    @Test
    public void queryStudentMap(){
        Map<String, Object> map = jdbcTemplate.queryForMap("select * from stu where sid = ?", 3);
        System.out.println(map);//{sid=3, sname=小龙女, schoolName=绝情谷, score=10000.0}
    }

    //查询所有Student对象  返回List<map<String,Object>> queryForList
    @Test
    public void queryStudentList(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from stu");
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }
    //6.查询所有学生返回一个List<Student>对象
    @Test
    public void queryLsit(){
        List<Student> list = jdbcTemplate.query("select * from stu", new BeanPropertyRowMapper<Student>(Student.class));
        for (Student student : list) {
            System.out.println(list);
        }
    }

}
