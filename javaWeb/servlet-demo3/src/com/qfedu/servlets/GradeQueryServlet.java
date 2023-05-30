package com.qfedu.servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;

@WebServlet("/GradeQueryServlet")
public class GradeQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //获取请求方式
//        String method = req.getMethod();
//        //获取请求URL，不包含参数
//        String url = req.getRequestURL().toString();
//        //获取请求URL参数，根据参数的key获取参数的value，如果参数通过输入框提交数据则参数要和输入框的name属性保持一致
//        String p1 = req.getParameter("k1");
//        //获取客户端提交的协议和版本
//        String protocol = req.getProtocol();
//        Enumeration<String> en =  req.getHeaderNames();
//        while (en.hasMoreElements()) {
//            String key = en.nextElement();
//            String value = req.getHeader(key);
//            System.out.println(key + ":" + value);
//        }
        //1接收学号和课程编号
        String stuNum = req.getParameter("stuNum");
        String curseId = req.getParameter("curseId");

        //查询数据库
        int grade = 95;
        //3通过response响应浏览器
        //[设置响应状态行]
        //设置状态行中的状态码
        resp.setStatus(200);
        //[设置响应头]
        //设置响应头中的contentType属性,设置响应客户端的数据格式
        resp.setContentType("text/html");
        //设置响应客户端的数据长度
        //resp.setContentLength(1024);
        //设置其他的响应头数据
        resp.setHeader("Connection", "keep-alive");
        //[设置响应正文]
        //设置响应客户端的编码格式，不属于响应头
        resp.setCharacterEncoding("utf-8");
        //通过response对象获取输出流
        //字节流（图片等必须用字节流）
        //ServletOutputStream outputStream = resp.getOutputStream();
        //字符流（文本数据更方便）
        PrintWriter out = resp.getWriter();
        //通过流写出的数据，就会以响应正文的形式传输给客户端浏览器，如果浏览器可以识别数据则直接显示
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<title>学生成绩查询结果</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div style='padding: 50px; font-size: 50px; text-align: center; border: 1px gray solid; margin: auto;'>");
        out.println("<label>您的成绩为：</label>");
        out.println("<label style='color: red;'>" + grade + "</label>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求正文
        //获取客户端请求的输入流从输入流中读取请求正文
        ServletInputStream inputStream = req.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String s = reader.readLine();
        System.out.println(s);
    }
}
