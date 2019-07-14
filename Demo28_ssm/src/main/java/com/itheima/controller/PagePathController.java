package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("user")
//@RequestMapping(value = {"user","page"})这样也可以
public class PagePathController {
/*
*
     * 可以将跳转页面进行抽取
     *      要求：访问的action的名称和页面的名称一致

*/

    @RequestMapping("{xxx}")
    public String goPage(@PathVariable("xxx")String path){
        return path;
    }

}

