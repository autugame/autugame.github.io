package com.qfedu.servlets;

import com.qfedu.dto.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //传递数据
        req.setAttribute("key1", 123);
        req.setAttribute("key2", "Hello EL!");
        req.setAttribute("key3", new Book("1001", "Java", "亮亮", 20.00));
        String[] arr = {"111", "222", "333"};
        req.setAttribute("key4", arr);
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("1001", "Java", "亮亮", 20.00));
        bookList.add(new Book("1002", "C++", "张三", 21.00));
        bookList.add(new Book("1003", "Python", "李四", 22.00));
        req.setAttribute("key5", bookList);
        Map<String, Book> map = new HashMap<>();
        map.put("1001", new Book("1001", "Java", "亮亮", 20.00));
        map.put("a1002", new Book("1002", "C++", "张三", 21.00));
        map.put("1003", new Book("1003", "Python", "李四", 22.00));
        req.setAttribute("key6", map);
        req.getRequestDispatcher("test.jsp").forward(req, resp);
    }
}
