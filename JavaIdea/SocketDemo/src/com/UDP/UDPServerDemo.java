package com.UDP;

import java.io.IOException;
import java.net.*;

public class UDPServerDemo {
    public static void main(String[] args) {
        String info = "good good study, day day up";
        byte[] bytes = info.getBytes();
        try {
            //封装一个数据包
            DatagramPacket dp = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("127.0.0.1"), 8000);
            DatagramSocket socket = new DatagramSocket(9000);
            socket.send(dp);
            socket.close();
            System.out.println("发送成功");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
