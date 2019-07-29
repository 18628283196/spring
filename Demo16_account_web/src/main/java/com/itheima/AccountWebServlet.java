package com.itheima;

import java.io.IOException;
import java.sql.SQLException;


public class AccountWebServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
        try {
            String inName = request.getParameter("inName");
            String outName = request.getParameter("outName");
            String smoney = request.getParameter("money");
            double money = Double.parseDouble(smoney);
            AccountServiceImpl as = new AccountServiceImpl();

            as.transfer(inName,outName,money);
            response.getWriter().print("转账成功");
        } catch (SQLException e) {
            response.getWriter().print("转账失败");
            e.printStackTrace();
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
