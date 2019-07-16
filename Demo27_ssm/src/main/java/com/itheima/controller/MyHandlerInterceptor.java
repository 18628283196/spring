package com.itheima.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器  实现HandlerInterceptor 重写里面的方法
 *          preHandle：请求处理器之前执行该方法，有拦截作用
 *          postHandle：处理器执行了，但还没有返回ModloeAndview的时候执行
 *          afterCompletion：处理器已执行完毕，ModelAndView也已返回，执行
 *  后台需要配置
 */
public class MyHandlerInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("11拦截器的。。。。preHandle");
        //返回值  true代表放行   false代表拦截不放行
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("22拦截器的。。。。postHandle");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("33拦截器的。。。。afterCompletion");
    }
}
