package com.vince;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerDemo {
    public static void main(String[] args) {
        //创建一个服务器端Socket(1024-65535)
        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("服务器已启动,正在等待客户端连接......");
            //等待客户端的链接，造成阻塞如果连接成功返回对象
            Socket accept = server.accept();
            System.out.println("连接成功" + server.getInetAddress().getHostAddress());
            BufferedReader bf = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            String info = bf.readLine();
            System.out.println(info);
            PrintStream ps = new PrintStream(new BufferedOutputStream(accept.getOutputStream()));
            ps.println("echo:" + info);
            ps.flush();
            ps.close();
            bf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
