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

        //检查用户名是否存在
        boolean r = !userName.startsWith("admin");

        //进行响应
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String str = r?"<label style='color: green'>用户名可用！</label>":"<label style='color: red'>用户名不可用！</label>";
        out.println(str);
        out.flush();
        out.close();
    }
}
