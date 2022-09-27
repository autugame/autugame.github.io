package com.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * 服务器端的消息处理器
 */
public class MinaServerHandler extends IoHandlerAdapter {
    //一次会话打开
    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
        System.out.println("welcome client" + session.getRemoteAddress());
    }
    //一次会话关闭
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
        System.out.println(session.getRemoteAddress() + "client closed");
    }
    //接受消息
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);
        String msg = (String) message;//接收到的消息对象
        //Message msg = (Message) message;
        System.out.println("收到客户端发来的消息:" + msg);
        //向客户端发送消息对象
        //msg.setInfo("吃好吃的");
        session.write(msg);
    }
}
