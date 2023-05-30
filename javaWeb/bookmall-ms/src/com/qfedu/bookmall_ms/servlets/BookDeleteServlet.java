package com.qfedu.bookmall_ms.servlets;

import com.qfedu.bookmall_ms.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BookDeleteServlet")
public class BookDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收图书ID
        String bookId = req.getParameter("bookId");
        //删除图书
        BookService bookService = new BookService();
        boolean b = bookService.deleteBook(bookId);

        //转发到提示页面
        req.setAttribute("tips", b?"<label style='color: green'>删除图书成功！</label>":"<label style='color: red'>删除图书失败！</label>");
        req.getRequestDispatcher("prompt.jsp").forward(req, resp);
    }
}
