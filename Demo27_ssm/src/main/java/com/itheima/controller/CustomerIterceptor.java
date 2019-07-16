package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户登录拦截器
 * 符合条件：1.tologin.action 放行---因为要跳转到login.jsp登录
 *              2.login.action   放行————登录过程放行
 *              3.Session中如果有user 不为空也放行
 */
public class CustomerIterceptor implements HandlerInterceptor{
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 1.获取Session，从Session中获取user
         * 2.Request对象有getRequestURI 方法，有路径，获取到该路径String；contain方法，判断是否包含指定的字符串
         * 3.判断路劲中是否包含了tologin.action  满足放行；是否包含了login.acton  满足放行；判断用户是否符合其中一条
         * 4.else  Session中放一些错误消息，没有权限 return false
         */
       // 1.获取Session，从Session中获取user
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //2.Request对象有getRequestURI 方法，有路径，获取到该路径String；contain方法，判断是否包含指定的字符串
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        // 3.判断路劲中是否包含了tologin.action  满足放行；是否包含了login.acton  满足放行；判断用户是否符合其中一条
        if (user != null || requestURI.contains("tologin.action") || requestURI.contains("login.action")){
            return true;
        }
        session.setAttribute("msg","<font color='red'>没有权限</font>");
        response.sendRedirect("/tologin.action");
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
