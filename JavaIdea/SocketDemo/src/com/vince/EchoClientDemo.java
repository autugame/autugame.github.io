package com.vince;

import java.io.*;
import java.net.Socket;

public class EchoClientDemo {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6666);
            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("服务器连接成功");
            ps.println("hello, my name is bin");
            ps.flush();
            String info = br.readLine();
            System.out.println(info);
            ps.close();
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
