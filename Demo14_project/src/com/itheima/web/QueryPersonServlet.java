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

@WebServlet("/QueryPersonServlet")
public class QueryPersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eidstr = request.getParameter("eid");
        System.out.println(eidstr);
        int eid = Integer.parseInt(eidstr);
        AllQueryImpl aq = null;
        try {
            aq = new AllQueryImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            user list = aq.queryService(eid);

            ObjectMapper om = new ObjectMapper();
            String jsonObj = om.writeValueAsString(list);
            response.getWriter().print(jsonObj);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
