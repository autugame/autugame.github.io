package com.autuo;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SystemRunTimeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("打印输出");
		System.err.println("出错了");
		int[] num1 = { 1, 2, 3, 4, 5, 6, 7, 8};
		int[] num2 = new int[ num1.length ];
		System.arraycopy(num1, 0, num2, 0, num1.length);
		System.out.println(Arrays.toString(num2));
		
		System.out.println(System.currentTimeMillis());
		Date nowdate = new Date(System.currentTimeMillis());
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		String now = df.format(nowdate);
		System.out.println(now);
		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.version"));
		Runtime rt = Runtime.getRuntime();
		System.out.println(rt.freeMemory());
		try {
			rt.exec("notepad");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.loadLibrary(libname);
	}

}
