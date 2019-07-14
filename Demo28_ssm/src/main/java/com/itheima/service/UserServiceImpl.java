package com.itheima.service;

import com.itheima.mapper.UserMapper1;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.User;
import com.itheima.pojo.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper1 mapper;

    public PageBean findPageBean(int pageNum, int rowsNum) {
        //创建PageBean
        PageBean pageBean = new PageBean();
        //设置total属性
        Long count = mapper.findTotal();
        pageBean.setTotal(count);
        //设置List<User> rows属性
        /**
         * 起始索引，每页显示的行数
         * 公式：起始索引=（当前页-1）*每页显示行数
         */
        int index = (pageNum-1)*rowsNum;
        List<User1> rows = mapper.findList(index,rowsNum);
        pageBean.setRows(rows);
        return pageBean;
    }

    public void addUser(User1 user) {
        mapper.addUser1(user);
    }
}
