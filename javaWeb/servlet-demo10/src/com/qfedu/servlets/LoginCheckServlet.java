package com.qfedu.servlets;

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
        //接收，用户名，用户密码，验证码
        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");
        String userCode = req.getParameter("userCode");
        //取出正确验证码
        HttpSession session = req.getSession();
        String vCode = (String) session.getAttribute("vCode");
        //比对验证码
        if (userCode.equals(vCode)){
            System.out.println("验证码正确");
            //校验账号和密码
        } else {
            System.out.println("验证码错误");
            //转发到登录页面并提示验证码错误
        }
    }
}
