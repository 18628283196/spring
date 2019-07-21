package com.itheima.aop_annotation;

public interface StudentService {
    public void study();
    //添加学生的方法=====作为前置增强的目标方法
    public void addStudent();

    //删除学生的方法=====作为后置增强的目标方法
    public void deleteStudent();

    //修改学生的方法=====作为环绕增强的目标方法
    public void updateStudent();

    //查询学生的方法=====作为异常增强的目标方法
    public void selectStudent();

    //批量删除学生的方法=====作为前置增强的目标方法
    public void batchDeleteStudent();

}
