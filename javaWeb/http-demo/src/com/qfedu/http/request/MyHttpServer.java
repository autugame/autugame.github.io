package com.qfedu.http.request;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyHttpServer {
    public static void main(String[] args) throws IOException {
        //创建一个网络服务器（可以通过浏览器请求这个服务）
        ServerSocket serverSocket = new ServerSocket(9999);
        //当浏览器请求我这个服务器之后，就建立网络连接（socket对象）
        Socket socket = serverSocket.accept();
        //通过socket对象的输入流，可以读取浏览器发送的HTTP请求
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        //读取浏览器发送的HTTP请求
        String content = null;
        while (!"".equals((content = reader.readLine()))){
            System.out.println(content);
        }

        //自定义Http服务器响应浏览器
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println("HTTP/1.1 200 ok");
        out.println("Content-Type: text/html;charset=utf-8");
        out.println("Date: Fri, 24 Mar 2023 16:41:39 GMT");
        out.println("Location: https://www.baidu.com/");
        out.println("P3p: CP=\" OTI DSP COR IVA OUR IND COM \"");
        out.println("P3p: CP=\" OTI DSP COR IVA OUR IND COM \"");
        out.println("Server: BWS/1.1");
        out.println("Traceid: 1679676099060692148214433188352113219423");
        out.println("X-Frame-Options: sameorigin");
        out.println("X-Ua-Compatible: IE=Edge,chrome=1");
        out.println("");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>这是自定义服务器的网页</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<label style=\"color: red; font-size: 18px;\">这是自定义服务器响应的内容</label>");
        out.println("</body");
        out.println("</html>");
        out.flush();
        out.close();
    }
}
