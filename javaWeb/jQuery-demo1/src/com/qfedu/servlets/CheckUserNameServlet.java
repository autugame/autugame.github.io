package com.qfedu.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CheckUserNameServlet")
public class CheckUserNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收用户名
        String userName = req.getParameter("userName");

        //判断是否可用
        boolean b = !userName.startsWith("admin");

        //响应ajax请求
        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String jsonStr = b?"{\"code\":1000, \"msg\":\"success\"}":"{\"code\":1001, \"msg\":\"fail\"}";
        PrintWriter out = resp.getWriter();
        out.println(jsonStr);
        out.flush();
        out.close();
    }
}
