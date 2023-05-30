package com.qfedu.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/FileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");
        //获取存储文件的files目录
        ServletContext servletContext = getServletContext();
        String dir = servletContext.getRealPath("files");
        String filePath = dir + "\\" + fileName;
        ServletOutputStream outputStream = resp.getOutputStream();
        //服务器文件写给客户端
        System.out.println(filePath);
        resp.setStatus(200);
        resp.setContentType("application/image");//设置响应类型如果浏览器无法识别则会提示另存为
        resp.addHeader("Content-Disposition", "attachment; fileName=" + fileName);
        FileInputStream fis = new FileInputStream(filePath);
        byte[] bs = new byte[1024];
        int len = -1;
        while ((len = fis.read(bs)) != -1){
            outputStream.write(bs, 0, len);
        }
        outputStream.close();
        fis.close();
    }
}
