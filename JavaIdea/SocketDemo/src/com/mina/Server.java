package com.mina;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.codec.serialization.ObjectSerializationEncoder;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) {
        //创建一个非阻塞的Server端nio
        SocketAcceptor acceptor = new NioSocketAcceptor();
        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
        //设定一个过滤器一行一行读取数据
        chain.addLast("myChin", new ProtocolCodecFilter(new TextLineCodecFactory()));
        //chain.addLast("ObjectFilter", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
        //设定服务器端的消息处理器
        acceptor.setHandler(new MinaServerHandler());
        //服务器的端口号
        int port = 9999;
        try {
            //绑定端口启动服务器立即返回不会阻塞
            acceptor.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Mina Server running，listener on" + port);
    }
}
