package com.itheima.pojo;

import lombok.Data;

@Data
public class Student {
    /**
     * `sid` INT PRIMARY KEY AUTO_INCREMENT ,
     `sname` VARCHAR (90),
     `schoolName` VARCHAR (300),
     `score` DOUBLE
     */
    private int sid;
    private String sname;
    private String schoolName;
    private Double score;
}
