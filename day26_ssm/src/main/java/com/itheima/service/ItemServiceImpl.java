package com.itheima.service;

import com.itheima.mapper.ItemMapper;
import com.itheima.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    public List<Item> findAll() {
        List<Item> list = itemMapper.queryAllItem();
        return list;
    }

    public Item findItemById(int id) {
       Item item = itemMapper.queryItemById(id);
        return item;
    }

    public void updateItem(Item item) {
        itemMapper.update(item);
    }
}
