package com.itheima.service;

import com.itheima.pojo.Item;

import java.util.List;

public interface ItemService {
    //查询所有商品
    public List<Item> findAll();


    Item findItemById(int id);

    void updateItem(Item item);
}
