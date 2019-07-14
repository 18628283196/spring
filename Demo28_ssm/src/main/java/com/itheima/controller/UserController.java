package com.itheima.controller;

import com.itheima.pojo.PageBean;
import com.itheima.pojo.User1;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    //跳转页面到users.jsp
    @RequestMapping("userList.action")
    public String showUser(){
        return  "users";
    }

    /**
     * 查询一页数据
     */
    @RequestMapping("list.action")
    @ResponseBody
    public PageBean findPageBean(Integer page,Integer rows){
        //直接调用service的方法
        PageBean pageBean = userService.findPageBean(page, rows);
        return pageBean;
    }


    /**
     * 跳转到新增页面user-add.jsp
     */

  /*  @RequestMapping("user-add.action")
    public String toAddPage(){
        return "user-add";
    }*/



    /**
     * 跳转到修改页面user-add.jsp
     */
/*
    @RequestMapping("user-edit.action")
    public String toEditPage(){
        return "user-edit";
    }*/


  /*  *
     * 可以将跳转页面进行抽取
     *      要求：访问的action的名称和页面的名称一致*/

  /*  @RequestMapping("{xxx}")
    public String goPage(@PathVariable("xxx")String path){
        return path;
    }*/

    /**
     * 新增用户
     */
    @RequestMapping("save.action")
    //@ResponseBody的作用其实是将java对象转为json格式的数据。
    @ResponseBody
    public Map<String,String> addUser(User1 user){
        Map<String,String> map = new HashMap<String,String>();
        //调用service方法
        try {
            userService.addUser(user);
            map.put("status","200");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status","500");
        }
        return map;
    }

}


