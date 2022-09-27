package com.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class CopyFileDemo {
	
	private static void randomAccessFileCopy() {
		try {
			RandomAccessFile in = new RandomAccessFile("E:\\360Downloads\\Software\\360驱动大师_2.0.0.1800.exe", "r");
			RandomAccessFile out = new RandomAccessFile("E:\\360驱动大师_2.0.0.1800.exe", "rw");
			
			FileChannel fcIn = in.getChannel();
			FileChannel fcOut = out.getChannel();
			
			long size = fcIn.size();//输入流的字节大小
			MappedByteBuffer inBuf = fcIn.map(MapMode.READ_ONLY, 0, size);
			MappedByteBuffer outBuf = fcOut.map(MapMode.READ_WRITE, 0, size);
			
			for (int i = 0; i < size; i++) {
				outBuf.put(inBuf.get(i));
			}
			
			fcIn.close();
			fcOut.close();
			in.close();
			out.close();
			System.out.println("文件复制成功");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static void copyFile() {
		try {
			//创建一个文件通道
			FileChannel in = new FileInputStream("E:\\360Downloads\\Software\\360驱动大师_2.0.0.1800.exe").getChannel();
			//创建一个输出文件通道
			FileChannel out = new FileOutputStream("E:\\新建文件夹\\360驱动大师_2.0.0.1800.exe").getChannel();
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			while (in.read(buf) != -1) {
				buf.flip();
				out.write(buf);
				buf.clear();
			}
			in.close();
			out.close();
			System.out.println("文件复制成功");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		//copyFile();
		randomAccessFileCopy();
	}

}
