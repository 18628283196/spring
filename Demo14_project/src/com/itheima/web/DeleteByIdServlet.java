package com.itheima.web;

import com.itheima.service.AllQueryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteByIdServlet")
public class DeleteByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eid = request.getParameter("eid");
        int i = Integer.parseInt(eid);
        AllQueryImpl ap = null;
        try {
            ap = new AllQueryImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            int count = ap.delete(i);
            response.getWriter().print(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
