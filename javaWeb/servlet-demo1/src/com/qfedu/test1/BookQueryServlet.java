package com.qfedu.test1;

import com.qfedu.dto.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/book-query")
public class BookQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BookQueryServlet-doGet");
        //动态生成html

        //1，接收到浏览器请求时传递的图书id
        String bid = req.getParameter("bookId");
        //2，根据bid查询数据库图书表
        Map<String, Book>bookMap = new HashMap<>();
        bookMap.put("1001", new Book("1001", "JAVA", "张三", "55.66", ""));
        bookMap.put("1002", new Book("1002", "C++", "李四", "22.33", ""));
        bookMap.put("1003", new Book("1003", "PYTHON", "王五", "44.30", ""));
        //book就是根据用户请求查询到的动态数据
        Book book = bookMap.get(bid);
        //3，将查询到的图书信息生成网页，通过IO流，将网页响应给浏览器
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        //通过输出流响应网页数据
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\"><title>这是Servlet响应的网页</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table style=\"border: 1px solid lightgreen; width: 1000px;\" align='center' border='1' cellspacing='0'>");
        out.println("<tr style=\"font-weight: bold;\"><td>图书编号</td><td>图书名称</td><td>图书作者</td><td>图书价格</td><td>图书封面</td></tr>");
        out.println("<tr>");
        out.println("<td>" + book.getBookId() + "</td>");
        out.println("<td>" + book.getBookName() + "</td>");
        out.println("<td>" + book.getBookAuthor() + "</td>");
        out.println("<td>" + book.getBookPrice() + "</td>");
        out.println("<td>" + book.getBookImgPath() + "</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BookQueryServlet-doPost");
    }
}
