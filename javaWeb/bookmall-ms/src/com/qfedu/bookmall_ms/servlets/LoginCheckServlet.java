package com.qfedu.bookmall_ms.servlets;

import com.qfedu.bookmall_ms.dto.User;
import com.qfedu.bookmall_ms.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收账号和密码
        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");

        //调用userService校验登录
        UserService userService = new UserService();
        User user = userService.checkLogin(userName, userPwd);

        //根据校验结果进行跳转和提示
        if (user == null){
            //登录失败,传递错误提示信息
            req.setAttribute("tips", "<label style='color: red'>账号或密码错误，登录失败!</label>");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            //登陆成功，将用户信息存储到session
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("index.jsp");
        }
    }
}
