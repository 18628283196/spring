package com.itheima.controller;

import com.itheima.pojo.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Controller
public class ItemController {
    //查询全部商品
    //到时候访问的路径为：localhost:8080/Demo21/item.action
    @RequestMapping("item.action")
    public ModelAndView queryAll() {
        //创建MoModelAndView对象，模型与视图，使用可以放数据到域中，设定跳转的页面
        ModelAndView modelAndView = new ModelAndView();
        //模拟假数据，省略service调用
        List<Item> list = new ArrayList<Item>();
           /* private int id;
            private String name;
            private Float price;
            private String detail;
            private String pic;
            private String createtime;*/
        Item item1 = new Item(1, "华为P30", 6000.0, "摄像50倍聚焦", new Date());
        Item item2 = new Item(2, "三星", 6900.0, "爆炸", new Date());
        Item item3 = new Item(3, "小米", 3000.0, "性价比高", new Date());

        list.add(item1);
        list.add(item2);
        list.add(item3);

        //数据放到ModelAndView中，相当于放到域中
        modelAndView.addObject("itemList", list);
        //指定跳转的页面
        modelAndView.setViewName("/WEB-INF/jsp/itemList.jsp");

        return modelAndView;
    }
}