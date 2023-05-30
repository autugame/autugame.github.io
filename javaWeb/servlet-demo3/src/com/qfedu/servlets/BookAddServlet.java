package com.qfedu.servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet("/BookAddServlet")
public class BookAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //此方法获取的客户端类型一律为String类型，根据需要可进行类型转换
        int id = Integer.parseInt(req.getParameter("bookId"));
        String name = req.getParameter("bookName");
        String author = req.getParameter("bookAuthor");
        double price = Double.parseDouble(req.getParameter("bookPrice"));
        System.out.println("图书编号" + id);
        System.out.println("图书名称" + name);
        System.out.println("图书作者" + author);
        System.out.println("图书价格" + price);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如果页面采用form表单post方式提交数据，数据是通过请求正文传递的
//        ServletInputStream inputStream = req.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//        String s = reader.readLine();
//        System.out.println(s);
        //在servlet中接收数据之前通过request对象设置http请求数据的编码方式
        req.setCharacterEncoding("utf-8");
        //2.form表单post方式提交的数据也可以通过request对象的Parameter来接收,不能再打开输入流
        int id = Integer.parseInt(req.getParameter("bookId"));
        String name = req.getParameter("bookName");
        String author = req.getParameter("bookAuthor");
        double price = Double.parseDouble(req.getParameter("bookPrice"));
        System.out.println("图书编号" + id);
        System.out.println("图书名称" + name);
        System.out.println("图书作者" + author);
        System.out.println("图书价格" + price);
    }
}
