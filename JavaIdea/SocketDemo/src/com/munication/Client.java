package com.munication;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ExecutorService es = Executors.newSingleThreadExecutor();
        try {
            Socket socket = new Socket("localhost", 8888);
            System.out.println("服务器连接成功");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //向服务器发送登录信息
            System.out.println("请输入名称");
            String name = input.nextLine();
            Message msg = new Message(name, null, MessageType.TYPE_LOGIN, null);
            oos.writeObject(msg);
            msg = (Message) ois.readObject();
            System.out.println(msg.getInfo());
            //启动读取消息线程
            es.execute(new ReadInfo(ois));
            //使用主线程实现发送消息
            boolean flag = true;
            while (flag) {
                msg = new Message();
                System.out.println("To:");
                msg.setTo(input.nextLine());
                msg.setFrom(name);
                msg.setType(MessageType.TYPE_SEND);
                System.out.println("Info:");
                msg.setInfo(input.nextLine());
                oos.writeObject(msg);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

//读取消息
class ReadInfo implements Runnable {
    private ObjectInputStream in;
    private boolean flag = true;

    public ReadInfo(ObjectInputStream in) {
        this.in = in;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            while (flag) {

                Message message = (Message) in.readObject();
                System.out.println("[" + message.getFrom() + "]对我说:" + message.getInfo());

            }
            if (in != null) {
                in.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
