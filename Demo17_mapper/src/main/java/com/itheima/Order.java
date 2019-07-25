package com.itheima;

import lombok.Data;

import java.util.Date;
@Data
public class Order {
    /**
     id INT(11) PRIMARY KEY AUTO_INCREMENT,
     username VARCHAR(32) NOT NULL COMMENT '用户名称',
     birthday DATE DEFAULT NULL COMMENT '生日',
     sex CHAR(1) DEFAULT NULL COMMENT '性别',
     address VARCHAR(256) DEFAULT NULL COMMENT '地址'

     id INT PRIMARY KEY AUTO_INCREMENT,
     user_id INT NOT NULL ,
     number VARCHAR(50) NOT NULL,
     createtime DATETIME NOT NULL,
     note VARCHAR(100) DEFAULT NULL,
     */
    private int id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    private int user_id;
    private String number;
    private Date createtime;
    private String note;
}
