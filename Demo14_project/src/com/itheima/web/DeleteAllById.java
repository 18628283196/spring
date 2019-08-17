package com.itheima.web;

import com.itheima.service.AllQueryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteAllById")
public class DeleteAllById extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //接受参数
            String dir = request.getParameter("dir");
            //创建service对象
            AllQueryImpl aq = new AllQueryImpl();
            int i = aq.deleteAllById(dir);
            //回调函数
            response.getWriter().print(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
