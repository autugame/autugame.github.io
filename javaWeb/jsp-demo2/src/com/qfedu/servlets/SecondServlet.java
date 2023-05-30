package com.qfedu.servlets;

import com.qfedu.dto.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("score", 99);
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("1001", "Java", "亮亮", 20.00));
        bookList.add(new Book("1002", "C++", "张三", 21.00));
        bookList.add(new Book("1003", "Python", "李四", 22.00));
        bookList.add(new Book("1004", "PHP", "王五", 50.00));
        bookList.add(new Book("1005", "HTML", "赵六", 10.00));
        req.setAttribute("bookList", bookList);

        //传递日期和数字
        req.setAttribute("num", "3.141592653");
        req.setAttribute("date", new Date());

        req.getRequestDispatcher("test_jstl_core.jsp").forward(req, resp);
    }
}
