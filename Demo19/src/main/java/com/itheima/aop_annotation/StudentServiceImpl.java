package com.itheima.aop_annotation;

public class StudentServiceImpl implements StudentService {
    public void study() {
        System.out.println("正在学习。。。");
    }

    public void addStudent() {
        System.out.println("添加学生。。。");
    }

    public void deleteStudent() {
        System.out.println("删除学生。。。");
    }

    public void updateStudent() {
        System.out.println("修改学生。。。");
    }

    public void selectStudent() {
        System.out.println("查询学生。。。");
        int i = 1/0;
    }

    public void batchDeleteStudent() {
        System.out.println("批量删除学生。。。");
    }
}
