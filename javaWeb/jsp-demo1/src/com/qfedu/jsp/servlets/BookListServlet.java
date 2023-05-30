package com.qfedu.jsp.servlets;

import com.qfedu.jsp.dao.BookDAO;
import com.qfedu.jsp.dto.Book;

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
        //调用BookDAO查询图书信息
        List<Book> bookList = new BookDAO().listBooks();

        //将数据转发到book-list.jsp进行动态显示
        req.setAttribute("bookList", bookList);
        req.getRequestDispatcher("book-list.jsp").forward(req, resp);
    }
}
