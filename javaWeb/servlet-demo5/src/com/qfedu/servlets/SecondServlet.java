package com.qfedu.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //读取Cookie当客户端再次请求服务器时，通过request将Cookie传递到服务器
        //通过request对象获取浏览器传递的Cookie
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies){
            if ("key1".equals(cookie.getName())){
                String value = cookie.getValue();
                System.out.println(value);
            }
        }
    }
}
