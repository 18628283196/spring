package com.itheima.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.pojo.user;
import com.itheima.service.AllQueryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/AllDataServlet")
public class AllDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AllQueryImpl aq = null;
        try {
            aq = new AllQueryImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            List<user> list = aq.queryAll();
            //创建ObjectMapper对象,将list对象转为json对象
            ObjectMapper om = new ObjectMapper();
            String jsonObj = om.writeValueAsString(list);
            //将数据写会前台页面
            response.getWriter().print(jsonObj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
