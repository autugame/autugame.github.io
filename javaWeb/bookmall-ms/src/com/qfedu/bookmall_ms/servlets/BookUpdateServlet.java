package com.qfedu.bookmall_ms.servlets;

import com.qfedu.bookmall_ms.dto.Book;
import com.qfedu.bookmall_ms.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BookUpdateServlet")
public class BookUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收修改后的图书信息
        String bookId = req.getParameter("bookId");
        String bookName = req.getParameter("bookName");
        String bookAuthor = req.getParameter("bookAuthor");
        double bookPrice = Double.parseDouble(req.getParameter("bookPrice"));
        String bookImgPath = req.getParameter("bookImgPath");
        String bookDesc = req.getParameter("bookDesc");
        int bookStock = Integer.parseInt(req.getParameter("bookStock"));
        int bookType = Integer.parseInt(req.getParameter("bookType"));
        //执行修改
        Book book = new Book(bookId, bookName, bookAuthor, bookPrice, bookImgPath, bookDesc, bookStock, bookType);
        BookService bookService = new BookService();
        boolean b = bookService.modifyBook(book);
        req.setAttribute("tips", b?"<label style='color: green'>图书修改成功！</label>":"<label style='color: red'>图书修改失败！</label>");
        req.getRequestDispatcher("prompt.jsp").forward(req, resp);
    }
}
