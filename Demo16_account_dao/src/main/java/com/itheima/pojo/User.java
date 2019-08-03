package com.itheima.pojo;

public class User {
    private String name;
    private double money;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public User(String name, double money) {

        this.name = name;
        this.money = money;
    }
}
