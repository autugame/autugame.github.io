package com.qfedu.servlets;

import com.qfedu.dto.Book;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

@WebServlet("/BookSaveServlet")
//处理非压缩提交数据
@MultipartConfig
public class BookSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String bookId = req.getParameter("bookId");
        String bookName = req.getParameter("bookName");
        //接收表单提交的文件
        Part bookImg = req.getPart("bookImg");
        //接收表单中所有文件
        //Collection<Part> parts = req.getParts();

        //保存图片
        //获取files目录服务器路径不是工作空间路径
        ServletContext servletContext = getServletContext();
        String realPath = servletContext.getRealPath("/files");
        System.out.println(realPath);
        //给上传文件重命名、
        String header = bookImg.getHeader("content-Disposition");
        int begin = header.lastIndexOf(".");
        int end = header.lastIndexOf("\"");
        String ext = header.substring(begin, end);
        //(取名 时间毫秒数 UUID 雪花算法)
//        String fileName = System.currentTimeMillis() + ext;
        String fileName = UUID.randomUUID() + ext;

        //存储文件到目录
        bookImg.write(realPath + "\\" + fileName);
        //将图书信息保存到数据库
        Book book = new Book(bookId, bookName, "files/" + fileName);
    }
}
