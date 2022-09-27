package com.nio;

import java.nio.ByteBuffer;

public class NIODemo {

	public static void main(String[] args) {
		//创建一个字节缓冲区
		ByteBuffer buf = ByteBuffer.allocate(8);
		
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		
		System.out.println("-------");
		
		//向缓冲区中写入数据
		buf.put((byte)10);
		buf.put((byte)20);
		buf.put((byte)30);
		buf.put((byte)40);
		
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		
		//缓冲区反转
		buf.flip();
		
		System.out.println("-------");
		
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		
		if (buf.hasRemaining()) {
			for (int i = 0; i < buf.remaining(); i++) {
				byte b = buf.get(i);
				System.out.println(b);
			}
		}
		
		System.out.println("-------");
		
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		
	}

}
