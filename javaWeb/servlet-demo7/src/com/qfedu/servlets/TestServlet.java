package com.qfedu.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取当前web应用在服务器上的信息
        //servlet上下文对象
        //获取servlet context对象
        ServletContext servletContext = getServletContext();
        //获取当前web应用的上下文路径,在web服务器上的访问路径
        String contextPath = servletContext.getContextPath();
//        String contextPath1 = req.getContextPath();
//        System.out.println(contextPath);
        //获取web项目中的目录在服务器上的绝对路径
        String files = servletContext.getRealPath("/files");
//        System.out.println(contextPath);
//        System.out.println(files);
        servletContext.setAttribute("ckey", "hello");
        //获取web.xml中的全局参数
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        //根据key获取value
        String key1 = servletContext.getInitParameter("key1");
        System.out.println(key1);
        //获取当前servlet类的config对象
        ServletConfig servletConfig = getServletConfig();
        //获取当前servlet类路径
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);
    }
}
