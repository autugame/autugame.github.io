package com.qfedu.web;

import com.qfedu.pojo.User;
import com.qfedu.service.UserService;
import com.qfedu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class QueryUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.Set encoding.
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //2.Create a user service object.
        UserService userService = new UserServiceImpl();
        //3.query.
        List<User> users;
        try {
            users = userService.queryUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //4.Place the query list in the request.
        req.setAttribute("users", users);
        //5.Forward to show.jsp.
        req.getRequestDispatcher("show.jsp").forward(req, resp);
    }
}
