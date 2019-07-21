package com.itheima.servlet;

import com.itheima.service.DengLuServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 存在问题:每次都会加载spring的核心配置文件，多次创建对象，造成资源浪费
 * 想法：ApplicationContext。xml只加载一次，Tomcat启动时就加载
 * spring提供解决方案：spring-web.jar
 * 提供了对应的监听器，可以实现服务器启动时就加载配置问价
 * 重写给了的类，提供了获取对象的方式
 */

public class DengLuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        WebApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

        DengLuServiceImpl denglu = context.getBean("dengLuServiceImpl", DengLuServiceImpl.class);
        denglu.loginService();
    }
}
