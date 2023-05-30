package com.qfedu.bookmall_ms.servlets;

import com.qfedu.bookmall_ms.dto.Book;
import com.qfedu.bookmall_ms.service.BookService;
import com.qfedu.bookmall_ms.utils.PageHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收客户端传递的页码
        String num = req.getParameter("pageNum");
        int pageNum = num == null ? 1 : Integer.parseInt(num);
        //定义pagesize
        int pageSize = 5;
        //查询当前页图书信息
        BookService bookService = new BookService();
        PageHelper<Book> bookPageHelper = bookService.listBooksByPage(pageNum, pageSize);
        //查询图书的总页数
        int pageCount = 0;
        //转发当前页数据的集合，当前页码，总页数图书集合到book-list.jsap
        req.setAttribute("bookPageHelper", bookPageHelper);
        req.getRequestDispatcher("book-list.jsp").forward(req, resp);
    }
}
