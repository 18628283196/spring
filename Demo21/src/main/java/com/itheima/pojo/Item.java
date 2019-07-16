package com.itheima.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 商品表
 */
@Data
public class Item {
/*      `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NOT NULL COMMENT '商品名称',
            `price` FLOAT(10,1) NOT NULL COMMENT '商品定价',
            `detail` VARCHAR(5000) COMMENT '商品描述',
            `pic` VARCHAR(64) DEFAULT NULL COMMENT '商品图片',
            `createtime` DATETIME NOT NULL COMMENT '生产日期'*/
        private int id;
        private String name;
        private double price;
        private String detail;
        private String pic;
        private Date createtime;

    public Item(int id, String name, double price, String detail, Date createtime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.createtime = createtime;
    }

    public Item() {

    }
}
