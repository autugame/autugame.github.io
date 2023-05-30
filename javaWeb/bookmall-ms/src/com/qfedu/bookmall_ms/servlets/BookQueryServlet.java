package com.qfedu.bookmall_ms.servlets;

import com.qfedu.bookmall_ms.dto.Book;
import com.qfedu.bookmall_ms.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BookQueryServlet")
public class BookQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收图书ID
        String bookId = req.getParameter("bookId");
        //查询图书信息
        Book book = new BookService().getBook(bookId);
        //将修改前的信息传递到修改页面
        req.setAttribute("book", book);
        req.getRequestDispatcher("book-modify.jsp").forward(req, resp);
    }
}
