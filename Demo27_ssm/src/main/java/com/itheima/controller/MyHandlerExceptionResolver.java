package com.itheima.controller;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常解析器获取  HandlerExceptionResolver
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    //异常方法   获取异常后执行该异常方法
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //定义一个msg信息，保存异常信息
            String msg = "";
        //判断如果是自定义异常 处理一下，获取信息方法msg
            if(ex instanceof MyException){
               //ex 使我们自定义异常信息
                msg = ex.getMessage();
            }else{
                //如果是运行时异常 获取错误消息放到msg
                //打印堆栈的异常信息
                StringWriter out = new StringWriter();
                PrintWriter s = new PrintWriter(out);
                msg = out.toString();//msg就记录了运行时异常
            }

                //给程序员发邮件，发短信通知它异常
                System.out.println("给程序员发邮件...报告错误消息");
                //返回数据给页面ModelAndView
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.addObject("error",msg);
                modelAndView.setViewName("error");
               return modelAndView;
    }
}
