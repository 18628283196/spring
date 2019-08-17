package com.itheima.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.pojo.PageBean;
import com.itheima.service.AllQueryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/PageBeanQueryServlet")
public class PageBeanQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得当前页
        String currentPageStr = request.getParameter("currentPage");
        if(currentPageStr == null || "".equals(currentPageStr.trim())){
            currentPageStr="1";
        }
        long  currentPage = Long.parseLong(currentPageStr);
        int rowa = 5;
        //创建service对象
        try {
            AllQueryImpl aq = new AllQueryImpl();
            //调用查询方法
            PageBean pageBean =  aq.findPageBean(currentPage,rowa);
            //把pageBean转化为json对象
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(pageBean);
            //将转换的数据写回到回调函数中
            response.getWriter().print(s);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
