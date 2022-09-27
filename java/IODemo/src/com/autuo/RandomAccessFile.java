package com.autuo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RandomAccessFile {

	public static void main(String[] args) {
		try {
			java.io.RandomAccessFile r = new java.io.RandomAccessFile("E:\\Download\\jdk-8u341-windows-x64.exe", "r");
			java.io.RandomAccessFile w = new java.io.RandomAccessFile("E:\\text", "rw+");
			byte[] bytes = new byte[1024];
			int len = -1;
			while ((len = r.read(bytes)) != -1) {
				w.write(bytes, 0, len);
			}
			w.close();
			r.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("copy success.");
	}

}
