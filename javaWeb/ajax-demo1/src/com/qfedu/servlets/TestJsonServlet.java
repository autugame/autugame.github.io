package com.qfedu.servlets;

import com.google.gson.Gson;
import com.qfedu.dto.Student;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/TestJsonServlet")
public class TestJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收POST请求
        req.setCharacterEncoding("UTF-8");
        ServletInputStream inputStream = req.getInputStream();
        StringBuilder builder = new StringBuilder();
        byte[] bs = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(bs)) != -1){
            String s = new String(bs, 0, len, StandardCharsets.UTF_8);
            builder.append(s);
        }
        String str = builder.toString();
        //2.将接收的json字符串转换成java对象
        Gson gson = new Gson();
        Student student = gson.fromJson(str, Student.class);
        System.out.println(student);
        inputStream.close();
        //java对象转换成json格式
        Student stu2 = new Student("10002", "Lucy", "女");
        String jsonStr = gson.toJson(stu2);
        //响应前段ajax请求
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(jsonStr);
        out.flush();
        out.close();
    }
}
