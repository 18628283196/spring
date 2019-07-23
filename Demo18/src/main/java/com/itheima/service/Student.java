package com.itheima.service;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String sex;
    private Date birthday;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Student(int id, String name, String sex, Date birthday) {

        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public Student() {

    }
}
