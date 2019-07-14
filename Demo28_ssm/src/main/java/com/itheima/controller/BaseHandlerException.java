package com.itheima.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 将异常处理的方法抽取出来
 */

public class BaseHandlerException {
    //@ExceptionHandler表示拦截异常
    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(Exception ex){
        //获取异常信息
        String message = ex.getMessage();
        //把信息放到ModelAndView中
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg",message);
        //设置错误页面
        modelAndView.setViewName("error");
        //跳转return对象
        return modelAndView;
    }

}
