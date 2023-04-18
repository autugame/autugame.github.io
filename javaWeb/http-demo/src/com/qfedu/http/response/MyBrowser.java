package com.qfedu.http.response;

import java.io.*;
import java.net.Socket;

public class MyBrowser {
    public static void main(String[] args) throws IOException {
        //将上一个案例中浏览器发送给MyHttpServer的http请求内容，发送给百度

        //向百度服务器发送请求
        Socket socket = new Socket("www.baidu.com", 80);
        System.out.println(socket);
        //2，通过连接中的输出流将HTTP请求内容发送给百度
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter out = new PrintWriter(outputStream);
        out.println("GET / HTTP/1.1");
        out.println("Host: www.baidu.com:80");
        out.println("Connection: keep-alive");
        out.println("sec-ch-ua: \"Microsoft Edge\";v=\"111\", \"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"111\"");
        out.println("sec-ch-ua-mobile: ?0");
        out.println("sec-ch-ua-platform: \"Windows\"");
        out.println("Upgrade-Insecure-Requests: 1");
        out.println("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.51");
        out.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
        out.println("Sec-Fetch-Site: none");
        out.println("Sec-Fetch-Mode: navigate");
        out.println("Sec-Fetch-User: ?1");
        out.println("Sec-Fetch-Dest: document");
        out.println("Accept-Encoding: gzip, deflate, br");
        out.println("Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
        out.println("");
        out.flush();
        //3,通过输入流接收百度的相应数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String responseContent = null;
        while((responseContent = reader.readLine()) != null) {
            System.out.println(responseContent);
        }
    }
}
