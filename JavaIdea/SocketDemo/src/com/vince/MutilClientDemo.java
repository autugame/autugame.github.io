package com.vince;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MutilClientDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", 6666);
            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("请输入");
            String info = input.nextLine();
            ps.println(info);
            ps.flush();
            info = br.readLine();
            System.out.println(info);
            ps.close();
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
