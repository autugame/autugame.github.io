package com.qfedu.jsp.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1，分别通过request，session，application传值
        req.setAttribute("key1", "value1");
        HttpSession session = req.getSession();
        session.setAttribute("key2", "value2");
        ServletContext application = req.getServletContext();
        application.setAttribute("key3", "value3");
        //2，转发到test3.jsp
        req.getRequestDispatcher("test3.jsp").forward(req, resp);
    }
}
