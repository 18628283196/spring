package com.itheima.web;


import com.itheima.pojo.Employee;
import com.itheima.service.AllQueryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/AddUserServletServlet")
public class AddUserServletServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        Map<String, String[]> parameterMap = request.getParameterMap();

        Employee emp = new Employee();
            BeanUtils.populate(emp,parameterMap);
            AllQueryImpl al = new AllQueryImpl();
            al.addAll(emp);
            response.sendRedirect(this.getServletContext().getContextPath()+"/show.html");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
