package com.qfedu.bookmall_ms.servlets;

import com.qfedu.bookmall_ms.dto.Book;
import com.qfedu.bookmall_ms.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/BookSaveServlet")
@MultipartConfig
public class BookSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收输入的图书信息
        String bookId = req.getParameter("bookId");
        String bookName = req.getParameter("bookName");
        String bookAuthor = req.getParameter("bookAuthor");
        double bookPrice = Double.parseDouble(req.getParameter("bookPrice"));
        String bookDesc = req.getParameter("bookDesc");
        int bookStock = Integer.parseInt(req.getParameter("bookStock"));
        int bookType = Integer.parseInt(req.getParameter("bookType"));

        //接收并保存图书的封面图片
        Part bookImg = req.getPart("bookImg");
        String header = bookImg.getHeader("content-Disposition");
        String ext = header.substring(header.lastIndexOf("."), header.lastIndexOf("\""));

        String fileName = UUID.randomUUID()+ext;
        //获取files目录在服务器中的路径
        String dir = getServletContext().getRealPath("/files");
        String savePath = dir+"\\"+fileName;
        //保存图片
        bookImg.write(savePath);
        //将图书信息保存到数据库
        Book book = new Book(bookId, bookName, bookAuthor, bookPrice, "files/"+fileName, bookDesc, bookStock, bookType);
        BookService bookService = new BookService();
        boolean b = bookService.saveBook(book);
        //跳转到提示页面并进行提示
        req.setAttribute("tips", b?"<label style='color: green'>添加图书成功！</label>":"<label style='color: red'>添加图书失败！</label>");
        req.getRequestDispatcher("prompt.jsp").forward(req, resp);
    }
}