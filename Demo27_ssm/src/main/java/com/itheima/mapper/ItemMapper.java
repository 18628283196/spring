package com.itheima.mapper;

import com.itheima.pojo.Item;

import java.util.List;

public interface ItemMapper {
    public List<Item> queryAllItem();

    Item queryItemById(int id);

    void update(Item item);
}
