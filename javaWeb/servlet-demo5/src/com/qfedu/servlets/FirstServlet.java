package com.qfedu.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //向浏览器存储一个Cookie
        //1,创建Cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        //设置Cookie生命周期
        cookie.setMaxAge(24*60*60); //单位秒,如果参数为0表示浏览器关闭销毁Cookie,参数为-1表示内存存储
        //2,写Cookie到客户端
        //将Cookie对象添加到Http响应头，写Cookie到客户端
        resp.addCookie(cookie);

        //响应界面
        //设置响应头
        resp.setStatus(200);
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        //响应正文
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<a href='SecondServlet'>请求SecondServlet</a>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }
}
