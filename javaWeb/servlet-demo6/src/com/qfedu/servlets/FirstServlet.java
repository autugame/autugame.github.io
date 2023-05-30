package com.qfedu.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //session对象是HttpSession接口的对象
        //getSession获取当前用户连接
        HttpSession session = req.getSession();
        String id = session.getId();
        //手动销毁session
        session.invalidate();
        //设置session对象的过期时间
        session.setMaxInactiveInterval(10);
        //将数据保存到session对象
        session.setAttribute("key1", "Hello！");

    }
}
